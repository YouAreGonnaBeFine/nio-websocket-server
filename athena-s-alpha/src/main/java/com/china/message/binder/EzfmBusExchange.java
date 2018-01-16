package com.china.message.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EzfmBusExchange {
	
	String INPUT = "ezfm_bus_exchange";

	@Input(EzfmBusExchange.INPUT)
	SubscribableChannel input();

}
