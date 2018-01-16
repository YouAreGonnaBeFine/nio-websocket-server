package com.china.message.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.china.message.bean.RealTimeMessage;
import com.china.ws.TextWebSocketFrameHandler;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

@Component
public class HeartBeat {

	@Scheduled(initialDelay = 5000, fixedDelay = 5000)
	public void heart() {
		RealTimeMessage syn = new RealTimeMessage();
		syn.setType("PING");
		syn.setContent(String.valueOf(TextWebSocketFrameHandler.onlineUser.size()));
		TextWebSocketFrameHandler.onlineUser.writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(syn)));
		System.out.println("PING");
	}

}
