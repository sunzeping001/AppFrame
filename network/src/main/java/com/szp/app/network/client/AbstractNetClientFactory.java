package com.szp.app.network.client;

import android.util.Log;

/**
 * Created by sunzeping on 17/9/17.
 * Function : 获取NetClient的工程类
 * Desc :
 */

public abstract class AbstractNetClientFactory {

	public static AbstractNetClientFactory getFactory(Class<?> clz){
		AbstractNetClientFactory factory = null;
		try {
			factory = (AbstractNetClientFactory) clz.newInstance();
		}catch (Exception ex){
			Log.e("szp",ex.getMessage() == null ? "" : ex.getMessage());
		}
		return factory;
	}

	/**
	 * 获取具体实现的NetClient实例
	 * @return
	 */
	public abstract INetClient getNetClient(String url);

}
