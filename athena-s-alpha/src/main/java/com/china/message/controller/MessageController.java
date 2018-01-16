package com.china.message.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.china.ws.TextWebSocketFrameHandler;

@RestController
@RequestMapping("/api")
public class MessageController {

	@RequestMapping(value = "/server", method = RequestMethod.GET)
	public String getWebServer() {
		return "服务器 A";
	}

	@RequestMapping(value = "/netty", method = RequestMethod.GET)
	public String getNettyServer() {
		return "localhost:8091";
	}

	@RequestMapping(value = "/channel", method = RequestMethod.GET)
	public int channel() {
		return TextWebSocketFrameHandler.onlineUser.size();
	}

	@RequestMapping(value = "/apocalypse", method = RequestMethod.GET)
	public String apocalypse() {
		TextWebSocketFrameHandler.onlineUser.close();
		return "ok";
	}

}
