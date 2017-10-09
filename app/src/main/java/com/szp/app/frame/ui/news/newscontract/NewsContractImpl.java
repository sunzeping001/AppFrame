package com.szp.app.frame.ui.news.newscontract;

import android.support.annotation.NonNull;

import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.ui.news.model.NewsFragmentModel;

import java.util.List;

/**
 * Created by sunzeping on 17/10/6.
 * Function :
 * Desc :
 */

public class NewsContractImpl implements INewsContract.IPresenter {

	private INewsContract.IView mView;

	private NewsFragmentModel mModel;

	public NewsContractImpl(@NonNull INewsContract.IView mView, @NonNull NewsFragmentModel mModel) {
		this.mView = mView;
		this.mModel = mModel;
		this.mView.setPresenter(this);
	}

	@Override
	public void start() {
		mView.initView();
	}


	@Override
	public List<NewsData> getData() {
		return mModel.getNewsDataList();
	}
}
