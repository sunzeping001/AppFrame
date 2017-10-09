package com.szp.app.frame.ui.home.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sunzeping on 17/10/3.
 * Function :
 * Desc :
 */

public class HomeFragmentModel implements Serializable {

	private List<String> listUrl;

	public List<String> getListUrl() {
		return listUrl;
	}

	public void setListUrl(List<String> listUrl) {
		this.listUrl = listUrl;
	}
}
