package com.szp.app.frame.ui.news.model;

import java.io.Serializable;

/**
 * Created by sunzeping on 17/10/6.
 * Function :
 * Desc :
 */

public class NewsData implements Serializable {

	private String url;
	private String content;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
