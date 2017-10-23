package com.szp.app.frame.ui.guanzhu.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.szp.app.frame.ui.guanzhu.GuanzhuFragment;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuListModel;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzeping on 17/10/22.
 * Function :
 * Desc :
 */

public class GuanzhuPresenterImpl implements IGuanzhuContract.IPresenter {

	private IGuanzhuContract.IView mView;

	private GuanzhuListModel guanzhuListModel;

	public GuanzhuPresenterImpl(@NonNull IGuanzhuContract.IView mView, @NonNull GuanzhuListModel model) {
		this.mView = mView;
		this.guanzhuListModel = model;
		this.mView.setPresenter(this);
	}

	@Override
	public void start() {
		mView.initData(guanzhuListModel.getGuanzhuModelList());
		mView.initView();
	}

	@Override
	public List<Fragment> getFragmentListData() {
		List<Fragment> list = new ArrayList<>();



		return list;
	}

	@Override
	public List<String> getTitles() {
		List<String> titles = new ArrayList<>();
		titles.add("关注");
		titles.add("热点");
		return titles;
	}
}
