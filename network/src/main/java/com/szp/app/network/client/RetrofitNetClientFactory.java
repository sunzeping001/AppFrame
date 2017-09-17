package com.szp.app.network.client;

/**
 * Created by sunzeping on 17/9/18.
 * Function :
 * Desc :
 */

public class RetrofitNetClientFactory extends AbstractNetClientFactory {
	@Override
	INetClient getNetClient(String url) {
		return new RetrofitNetClient(url);
	}
}
