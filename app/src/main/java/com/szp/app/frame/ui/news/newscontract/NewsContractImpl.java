package com.szp.app.frame.ui.news.newscontract;

import android.net.Uri;
import android.support.annotation.NonNull;

import android.text.Html;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.ui.news.model.NewsFragmentModel;

import java.util.ArrayList;
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

	@Override public List<ImageView> getImageViews() {
		List<ImageView> list = new ArrayList<>();
		for (int i = 0; i < mModel.getNewsDataList().size(); i++){
			ImageView imageView = new ImageView(mView.getParentActivity());
			Picasso.with(mView.getParentActivity()).load(Uri.parse(mModel.getNewsDataList().get(i).getUrl())).into(imageView);
			list.add(imageView);
		}
		return list;
	}

	@Override public int getDataSize() {
		return mModel.getNewsDataList().size();
	}
}
