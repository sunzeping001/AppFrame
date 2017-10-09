package com.szp.app.frame.ui.home.presenter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.szp.app.frame.ui.home.homecontract.IHomeContract;
import com.szp.app.frame.ui.home.model.HomeFragmentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzeping on 17/10/3.
 * Function : home fragment presenter
 * Desc :
 */

public class HomeFragmentContractImpl implements IHomeContract.IPresenter {

	private HomeFragmentModel homeFragmentModel;

	private IHomeContract.IView mView;

	private List<ImageView> imageViewList;

	public HomeFragmentContractImpl(@NonNull IHomeContract.IView view, @NonNull HomeFragmentModel model) {
		this.mView = view;
		this.homeFragmentModel = model;
		this.mView.setPresenter(this);
	}

	@Override
	public void start() {
		initData();
		mView.initViewPager(imageViewList);
	}

	/**
	 * 初始化viewpager数据内容
	 */
	private void initData() {
		imageViewList = new ArrayList<>();
		if (homeFragmentModel.getListUrl() != null && homeFragmentModel.getListUrl().size() > 0) {
			for (int i = 0; i < homeFragmentModel.getListUrl().size(); i++) {
				ImageView imageView = new ImageView(mView.getParentActivity());
				Picasso.with(mView.getParentActivity()).load(Uri.parse(homeFragmentModel.getListUrl().get(i))).fit().into(imageView);
				imageViewList.add(imageView);
			}
		}

	}
}
