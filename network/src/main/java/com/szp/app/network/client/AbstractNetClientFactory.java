package com.szp.app.network.client;

/**
 * Created by sunzeping on 17/9/17.
 * Function : 获取NetClient的工程类
 * Desc :
 */

public abstract class AbstractNetClientFactory {

	/**
	 * 获取具体实现的NetClient实例
	 * @return
	 */
	public abstract INetClient getNetClient(String url);

}
