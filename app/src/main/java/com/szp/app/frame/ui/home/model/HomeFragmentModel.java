package com.szp.app.frame.ui.home.model;

import com.szp.app.frame.ui.news.model.NewsData;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sunzeping on 17/10/3.
 * Function :
 * Desc :
 */

public class HomeFragmentModel implements Serializable {

	private List<NewsData> newsDataList;

	public List<NewsData> getNewsDataList() {
		return newsDataList;
	}

	public void setNewsDataList(List<NewsData> newsDataList) {
		this.newsDataList = newsDataList;
	}
}
