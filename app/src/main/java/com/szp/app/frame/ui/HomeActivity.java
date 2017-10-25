package com.szp.app.frame.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseActivity;
import com.szp.app.frame.net.CommonInterface;
import com.szp.app.frame.net.NetClient;
import com.szp.app.frame.ui.news.NewsFragment;
import com.szp.app.frame.ui.news.entity.NewsRequest;
import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.ui.news.model.NewsFragmentModel;
import com.szp.app.frame.ui.news.newscontract.NewsContractImpl;
import com.szp.app.frame.ui.toutiao.TouTiaoFragment;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoRequest;
import com.szp.app.frame.ui.toutiao.model.TouTiaoModel;
import com.szp.app.frame.ui.toutiao.presenter.TouTiaoPresenterImpl;
import com.szp.app.network.interf.IResultCallback;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

	private RadioButton rb_home;
	private RadioButton rb_news;
	private RadioButton rb_other;
	private RadioButton rb_mine;
	//头条key
	public static final String TOUTIAO_DATA = "toutiao_data";
	public static final String NEWS_DATA = "news_data";
	//头条数据
	private TouTiaoModel touTiaoModel;
	//新闻数据
	private NewsFragmentModel newsFragmentModel;

	/**
	 * 选择的默认索引
	 */
	private int mIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		getData();
		rb_home = (RadioButton) findViewById(R.id.home);
		rb_news = (RadioButton) findViewById(R.id.news);
		rb_other = (RadioButton) findViewById(R.id.other);
		rb_mine = (RadioButton) findViewById(R.id.mine);
		//设置监听事件
		rb_home.setOnClickListener(homeListener);
		rb_news.setOnClickListener(newsListener);
		rb_other.setOnClickListener(otherListener);
		rb_mine.setOnClickListener(mineListener);
	}

	/**
	 * 意外恢复
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		touTiaoModel = (TouTiaoModel) savedInstanceState.getSerializable(TOUTIAO_DATA);
		newsFragmentModel = (NewsFragmentModel) savedInstanceState.getSerializable(NEWS_DATA);
	}

	/**
	 * 获取外部数据
	 */
	private void getData() {
	}

	@Override
	protected void onResume() {
		super.onResume();
		showDefalutFragment();
	}

	/**
	 * 显示默认的fragment
	 */
	private void showDefalutFragment() {
		if (mIndex == 0) {
			getToutiaoData();
			//setSlector();
			//jumpToToutiaoFragment();
			//mIndex = 0;
		}
	}

	/**
	 * 设置点击效果
	 */
	private void setSlector() {
		switch (mIndex) {
			case 0:
				rb_home.setChecked(true);
				rb_news.setChecked(false);
				rb_other.setChecked(false);
				rb_mine.setChecked(false);
				break;

			case 1:
				rb_home.setChecked(false);
				rb_news.setChecked(true);
				rb_other.setChecked(false);
				rb_mine.setChecked(false);
				break;

			case 2:
				rb_home.setChecked(false);
				rb_news.setChecked(false);
				rb_other.setChecked(true);
				rb_mine.setChecked(false);
				break;

			case 3:
				rb_home.setChecked(false);
				rb_news.setChecked(false);
				rb_other.setChecked(false);
				rb_mine.setChecked(true);
				break;
			default:
				break;
		}
	}

	private View.OnClickListener homeListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mIndex == 0) {
				return;
			}
			//调用接口获取头条的数据
			getToutiaoData();
		}
	};

	/**
	 * 拉取头条接口获取数据
	 */
	private void getToutiaoData() {
		ToutiaoRequest toutiaoRequest = new ToutiaoRequest();
		toutiaoRequest.setRequestName("toutiao");
		new NetClient("http://www.fuckbeautiful.com").asynToutiaoQuery(toutiaoRequest,
				new IResultCallback<TouTiaoModel>() {
					@Override
					public void onSuccess(TouTiaoModel response) {
						touTiaoModel = response;
						jumpToToutiaoFragment();
						mIndex = 0;
						setSlector();
					}

					@Override
					public void onFail(String errorCode, String errorMsg) {
						Toast.makeText(HomeActivity.this, "errorCode = " + errorCode + "errorMsg = " + errorMsg,
								Toast.LENGTH_SHORT).show();
					}
				});
	}

	private View.OnClickListener newsListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mIndex == 1) {
				return;
			}
			getNewsData();
		}
	};

	/**
	 * 获取新闻数据
	 */
	private void getNewsData() {
		NewsRequest newsRequest = new NewsRequest();
		newsRequest.setRequestName("news");
		new NetClient("http://fuckyou.com").asynNewsQuery(newsRequest, new IResultCallback<NewsFragmentModel>() {
			@Override
			public void onSuccess(NewsFragmentModel response) {
				newsFragmentModel = response;
				jumpToNewsFragment();
				mIndex = 1;
				setSlector();
			}

			@Override
			public void onFail(String errorCode, String errorMsg) {

			}
		});


	}

	private View.OnClickListener otherListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			mIndex = 2;
			setSlector();
		}
	};

	private View.OnClickListener mineListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			mIndex = 3;
			setSlector();
		}
	};

	/**
	 * 跳转到首页
	 */
	private void jumpToToutiaoFragment() {
		TouTiaoFragment touTiaoFragment = new TouTiaoFragment();
		TouTiaoPresenterImpl tiaoPresenter = new TouTiaoPresenterImpl(touTiaoFragment, touTiaoModel);
		startFirstFragment(touTiaoFragment);
	}

	/**
	 * 跳转到首页
	 */
	private void jumpToNewsFragment() {
		NewsFragment newsFragment = new NewsFragment();
		NewsContractImpl newsContract = new NewsContractImpl(newsFragment, newsFragmentModel);
		startFirstFragment(newsFragment);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSerializable(TOUTIAO_DATA, touTiaoModel);
		outState.putSerializable(NEWS_DATA, newsFragmentModel);
	}
}
