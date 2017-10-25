package com.szp.app.frame.ui.news.entity;

import com.szp.app.frame.ui.news.model.NewsFragmentModel;
import com.szp.app.network.base.BaseResponse;

/**
 * Created by sunzeping on 17/10/25.
 * Function :
 * Desc :
 */

public class NewsReponse extends BaseResponse {

	private String code;

	private String errorMsg;

	private NewsFragmentModel newsFragmentModel;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public NewsFragmentModel getNewsFragmentModel() {
		return newsFragmentModel;
	}

	public void setNewsFragmentModel(NewsFragmentModel newsFragmentModel) {
		this.newsFragmentModel = newsFragmentModel;
	}
}
