package com.szp.app.frame.ui.news.entity;

import com.szp.app.network.base.BaseRequest;

/**
 * Created by sunzeping on 17/10/25.
 * Function :
 * Desc :
 */

public class NewsRequest extends BaseRequest {

	private String requestName;

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	@Override
	public void encrypData() {

	}
}
