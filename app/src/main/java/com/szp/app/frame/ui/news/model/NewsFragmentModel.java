package com.szp.app.frame.ui.news.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sunzeping on 17/10/6.
 * Function : 新闻界面的数据源
 * Desc :
 */

public class NewsFragmentModel implements Serializable {

	private List<NewsData> newsDataList;

	public List<NewsData> getNewsDataList() {
		return newsDataList;
	}

	public void setNewsDataList(List<NewsData> newsDataList) {
		this.newsDataList = newsDataList;
	}
}
