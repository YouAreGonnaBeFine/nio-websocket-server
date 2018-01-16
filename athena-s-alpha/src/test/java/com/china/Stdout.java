package com.china;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.china.message.bean.AcrMessage;
import com.china.message.bean.EzfmEvent;
import com.china.message.bean.RealTimeMessage;

public class Stdout {

	public static void main(String[] args) {
		RealTimeMessage syn = new RealTimeMessage();
		syn.setChannel(0L);
		syn.setType("PING");
		syn.setSn("asdx-fjis-komf");
		System.out.println(JSONObject.toJSON(syn));
		
		
		EzfmEvent ezfmEvent = new EzfmEvent();
		ezfmEvent.setType("ACR");
		AcrMessage acr = new AcrMessage();
		acr.setAlbum("a");
		acr.setArtists("b");
		acr.setChannel(0L);
		acr.setTime(new Date());
		acr.setTitle("c");
		ezfmEvent.setContent(JSON.toJSONString(acr));
		System.out.println(JSONObject.toJSON(ezfmEvent));
		

		
	}

}
