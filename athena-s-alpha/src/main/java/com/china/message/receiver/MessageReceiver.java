package com.china.message.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.alibaba.fastjson.JSON;
import com.china.message.bean.AcrMessage;
import com.china.message.bean.EzfmEvent;
import com.china.message.bean.RealTimeMessage;
import com.china.message.binder.EzfmBusExchange;
import com.china.ws.TextWebSocketFrameHandler;
import com.china.ws.util.EzfmChannelGroup;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

@EnableBinding(EzfmBusExchange.class)
public class MessageReceiver {

	@Autowired
	private EzfmChannelGroup ezfmChannelGroup;

	@StreamListener(EzfmBusExchange.INPUT)
	public void receive(EzfmEvent event) {

		if (event != null && "ACR".equalsIgnoreCase(event.getType())) {

			try {

				AcrMessage acr = JSON.parseObject(event.getContent(), AcrMessage.class);
				RealTimeMessage message = new RealTimeMessage();
				message.setType("ACR");
				message.setContent(event.getContent());
				TextWebSocketFrameHandler.channelGroups.get(acr.getChannel()).writeAndFlush(new TextWebSocketFrame(message.getContent()));
			}
			catch (Exception e) {
			}
		}

	}

	public EzfmChannelGroup getEzfmChannelGroup() {
		return ezfmChannelGroup;
	}

	public void setEzfmChannelGroup(EzfmChannelGroup ezfmChannelGroup) {
		this.ezfmChannelGroup = ezfmChannelGroup;
	}

}
