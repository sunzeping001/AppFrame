package com.szp.app.frame.ui.guanzhu.model;

import java.io.Serializable;

/**
 * Created by sunzeping on 17/10/22.
 * Function :
 * Desc :
 */

public class GuanzhuModel implements Serializable{
	private String title;
	private String content;
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
