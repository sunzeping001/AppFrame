package com.szp.app.frame.ui.guanzhu.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sunzeping on 17/10/22.
 * Function :
 * Desc :
 */

public class GuanzhuListModel implements Serializable {
	private List<GuanzhuModel> guanzhuModelList;

	public List<GuanzhuModel> getGuanzhuModelList() {
		return guanzhuModelList;
	}

	public void setGuanzhuModelList(List<GuanzhuModel> guanzhuModelList) {
		this.guanzhuModelList = guanzhuModelList;
	}
}
