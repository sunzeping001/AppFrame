package com.szp.app.frame.ui.toutiao.presenter;

import android.support.annotation.NonNull;

import com.szp.app.frame.ui.toutiao.model.TouTiaoModel;

/**
 * Created by sunzeping on 17/10/21.
 * Function :
 * Desc :
 */

public class TouTiaoPresenterImpl implements ITouTiaoPresenterContract.IPresenter {

	private ITouTiaoPresenterContract.IView mView;

	private TouTiaoModel mModel;

	public TouTiaoPresenterImpl(@NonNull ITouTiaoPresenterContract.IView mView, @NonNull TouTiaoModel mModel) {
		this.mView = mView;
		this.mModel = mModel;
		this.mView.setPresenter(this);
	}

	@Override
	public void start() {
		mView.initData();
		mView.initView();
	}
}
