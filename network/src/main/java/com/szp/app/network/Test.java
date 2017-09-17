package com.szp.app.network;

import com.szp.app.network.client.NetClient;
import com.szp.app.network.reponse.PersonBaseResponse;
import com.szp.app.network.requests.PersonRequest;

/**
 * Created by sunzeping on 17/9/17.
 * Function :
 * Desc :
 */

public class Test {

	public static void main(String[] args){
		String url = "http://192.168.0.108:8080/welcome/";
		String path = "TestPerson";
		NetClient netClient = new NetClient(url);
		PersonRequest request = new PersonRequest();
		request.setId("123");
		PersonBaseResponse response = (PersonBaseResponse)netClient.syncRequest(request);

	}
}
