package com.china.ws;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSONObject;
import com.china.message.bean.RealTimeMessage;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	public static ChannelGroup onlineUser = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	// public static Map<String, Channel> onlineUser = new HashMap<String,
	// Channel>();

	public static Map<Long, ChannelGroup> channelGroups = new ConcurrentHashMap<Long, ChannelGroup>();

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

		JSONObject message = JSONObject.parseObject(msg.text());

		if (message.getString("type").equalsIgnoreCase("SYN")) {
			login(ctx, message);
		}
		if (message.getString("type").equalsIgnoreCase("FIN")) {
			logout(ctx, message);
		}
		if (message.getString("type").equalsIgnoreCase("CHN")) {
			change(ctx, message);
		}
		if (message.getString("type").equalsIgnoreCase("PING")) {
			pong(ctx, message);
		}

	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

		Channel incoming = ctx.channel();

		onlineUser.add(incoming);
		onlineUser.add(incoming);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		onlineUser.remove(ctx.channel());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		rstChannel(ctx);
		onlineUser.remove(ctx.channel());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		rstChannel(ctx);
		onlineUser.remove(ctx.channel());
		ctx.close();
	}

	private void login(ChannelHandlerContext ctx, JSONObject message) {
		
		rstChannel(ctx);
		
		ChannelGroup channelGroup = channelGroups.get(message.getLong("channel"));
		if (channelGroup == null) {
			channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
			channelGroups.put(message.getLong("channel"), channelGroup);
		}
		channelGroup.add(ctx.channel());
		onlineUser.add(ctx.channel());

		RealTimeMessage ack = new RealTimeMessage();

		ack.setChannel(message.getLong("channel"));
		ack.setType("ACK");
		ack.setContent("online");
		ack.setSn(message.getString("sn"));
		ctx.channel().writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(ack)));
	}

	private void logout(ChannelHandlerContext ctx, JSONObject message) {
		
		rstChannel(ctx);

		RealTimeMessage ack = new RealTimeMessage();

		ack.setChannel(message.getLong("channel"));
		ack.setType("ACK");
		ack.setContent("offline");
		ack.setSn(message.getString("sn"));
		ctx.channel().writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(ack)));
	}

	private void change(ChannelHandlerContext ctx, JSONObject message) {
		
		rstChannel(ctx);
		
		ChannelGroup channelGroup = channelGroups.get(message.getLong("channel"));
		if (channelGroup == null) {
			channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
			channelGroups.put(message.getLong("channel"), channelGroup);
		}
		channelGroup.add(ctx.channel());
		onlineUser.add(ctx.channel());

		RealTimeMessage ack = new RealTimeMessage();

		ack.setChannel(message.getLong("channel"));
		ack.setType("ACK");
		ack.setContent("online");
		ack.setSn(message.getString("sn"));
		ctx.channel().writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(ack)));
	}

	private void rstChannel(ChannelHandlerContext ctx) {
		channelGroups.values().parallelStream().forEach(channelGroup -> {
			channelGroup.remove(ctx.channel());
		});
	}

	private void pong(ChannelHandlerContext ctx, JSONObject message) {
		RealTimeMessage ack = new RealTimeMessage();
		ack.setChannel(message.getLong("channel"));
		ack.setType("PONG");
		ack.setSn(message.getString("sn"));
		ctx.channel().writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(ack)));
	}

}
