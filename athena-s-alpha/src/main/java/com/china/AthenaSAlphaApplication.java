package com.china;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.china.ws.TextWebSocketFrameHandler;
import com.china.ws.WebsocketServer;
import com.china.ws.util.EzfmChannelGroup;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class AthenaSAlphaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(AthenaSAlphaApplication.class, args);
	}

	@Bean
	public EzfmChannelGroup ezfmChannelGroup() throws Exception {

		WebsocketServer websocketServer = new WebsocketServer(8091);

		new Thread(() -> {
			try {
				websocketServer.run();
			}
			catch (Exception e) {
			}
		}).start();

		EzfmChannelGroup ezfmChannelGroup = new EzfmChannelGroup();

		ezfmChannelGroup.setChannels(TextWebSocketFrameHandler.onlineUser);

		return ezfmChannelGroup;
	}
}
