package com.szp.app.frame.ui.news;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseFragment;
import com.szp.app.frame.ui.news.adapter.NewsHeaderAdapter;
import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.ui.news.newscontract.INewsContract;
import com.szp.app.frame.ui.newsitem.NewsItemActivity;
import com.szp.app.frame.utils.TextUtils;
import com.wyh.slideAdapter.BottomListener;
import com.wyh.slideAdapter.HeaderBind;
import com.wyh.slideAdapter.ItemBind;
import com.wyh.slideAdapter.ItemView;
import com.wyh.slideAdapter.SlideAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sunzeping on 17/10/6.
 * Function :
 * Desc :
 */

public class NewsFragment extends BaseFragment implements INewsContract.IView {

	private INewsContract.IPresenter mPresenter;

	private View mView;

	private RecyclerView mRecyclerView;

	private Timer timer = new Timer();
	private ViewPager viewPager;
	private final int DELAY = 3000;
	private final int PERIOD = 3000;
	//计算当前页面的索引
	private int count = 0;
	//是否暂停定时器
	private boolean isPause = false;
	private final int CYCLE = 0;
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (CYCLE == msg.what) {
				viewPager.setCurrentItem(count++);
			}
		}
	};

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		mView = LayoutInflater.from(mActivity).inflate(R.layout.news_fragment_layout, null);
		return mView;
	}

	@Override
	public void onResume() {
		super.onResume();
		isPause = false;
		if (mPresenter != null) {
			mPresenter.start();
		}
	}

	@Override
	public void initView() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (isPause) {
					return;
				}
				if (count == mPresenter.getDataSize() - 1) {
					count = 0;
				}
				Message message = new Message();
				message.what = CYCLE;
				mHandler.sendMessage(message);
			}
		}, DELAY, PERIOD);
		mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
		mRecyclerView.setLayoutManager(
				new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
		SlideAdapter.load(getListData())
				.item(R.layout.news_recycle_item_layout, 0, 0,
						R.layout.newsfragment_item_right_slider_layout, 0.35f)
				.header(R.layout.news_fragment_header_layout, 0.35f)
				.padding(10)
				.bind(itemBind)
				.bind(new HeaderBind() {
					@Override
					public void onBind(ItemView itemView, int i) {
						//header布局显示
						viewPager = itemView.getView(R.id.item_header_viewPager);
						viewPager.setAdapter(new NewsHeaderAdapter(mPresenter.getImageViews()));

					}
				})
				.footer(R.layout.news_bottom_layout, 0.2f)
				.listen(new BottomListener() {
					@Override
					public void onBottom(final ItemView footer, final SlideAdapter slideAdapter) {
						if (footer == null) {
							return;
						}
						footer.setText(R.id.tv_bottom, "正在加载...");
						ImageView imageView = footer.getView(R.id.img_bottom);
						Animation animation = AnimationUtils.loadAnimation(mActivity, R.anim.refresh_anim);
						imageView.startAnimation(animation);
						new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(1000);
								} catch (Exception ex) {
									ex.getMessage();
								}
								mActivity.runOnUiThread(new Runnable() {
									@Override
									public void run() {
										List data2 = getListData();
										slideAdapter.loadMore(data2);
										footer.setText(R.id.tv_bottom, "加载完成");
									}
								});
							}
						}).start();
					}
				})
				.into(mRecyclerView);
	}

	private ItemBind itemBind = new ItemBind<NewsData>() {
		@Override
		public void onBind(ItemView itemView, final NewsData data, int position) {
			itemView.setText(R.id.news_item_tv, data.getContent())
					.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							//点击item
							Intent intent = new Intent();
							intent.putExtra(NewsItemActivity.URL, data.getUrl());
							intent.putExtra(NewsItemActivity.CONTENT, data.getContent());
							intent.setClass(mActivity, NewsItemActivity.class);
							startActivity(intent);
						}
					})
					.setOnClickListener(R.id.btn_item_delete, new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							//点击textView
							Toast.makeText(mActivity, "你特么给删了？", Toast.LENGTH_SHORT).show();
						}
					})
		  /*.setOnClickListener(R.id.news_item_tv, new View.OnClickListener() {
			@Override
						public void onClick(View view) {
							//点击textView
							Toast.makeText(mActivity, "点击了文案", Toast.LENGTH_SHORT).show();
						}
					})
					.setOnClickListener(R.id.news_item_img, new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							Toast.makeText(mActivity, "点击了图片", Toast.LENGTH_SHORT).show();
						}
					})*/;
			//item布局显示
			ImageView imageView = itemView.getView(R.id.news_item_img);
			Picasso.with(mActivity).load(Uri.parse(data.getUrl())).fit().into(imageView);
		}
	};

	@Override
	public void setPresenter(INewsContract.IPresenter presenter) {
		this.mPresenter = presenter;
	}

	@Override
	public Activity getParentActivity() {
		return mActivity;
	}

	private List<NewsData> getListData() {
		List<NewsData> list = new ArrayList<>();
		list.addAll(mPresenter.getData());
		return list;
	}

	@Override
	public void onPause() {
		super.onPause();
		isPause = true;
	}
}
