package com.szp.app.frame.ui.news;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.ui.news.model.NewsFragmentModel;
import com.szp.app.frame.ui.news.newscontract.INewsContract;
import com.szp.app.frame.ui.newsitem.NewsItemActivity;
import com.wyh.slideAdapter.BottomListener;
import com.wyh.slideAdapter.FooterBind;
import com.wyh.slideAdapter.ItemBind;
import com.wyh.slideAdapter.ItemView;
import com.wyh.slideAdapter.SlideAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzeping on 17/10/6.
 * Function :
 * Desc :
 */

public class NewsFragment extends BaseFragment implements INewsContract.IView {

	private INewsContract.IPresenter mPresenter;

	private View mView;

	private RecyclerView mRecyclerView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mView = LayoutInflater.from(mActivity).inflate(R.layout.news_fragment_layout, null);
		return mView;
	}

	@Override
	public void onResume() {
		super.onResume();
		if (mPresenter != null) {
			mPresenter.start();
		}
	}

	@Override
	public void initView() {
		mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
		SlideAdapter.load(mPresenter.getData())
				.item(R.layout.news_recycle_item_layout)
				.padding(3)
				.bind(itemBind)
				.footer(R.layout.news_bottom_layout, 0.1f)
				.listen(new BottomListener() {
					@Override
					public void onBottom(final ItemView footer, final SlideAdapter slideAdapter) {
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
							intent.putExtra(NewsItemActivity.URL,data.getUrl());
							intent.putExtra(NewsItemActivity.CONTENT,data.getContent());
							intent.setClass(mActivity, NewsItemActivity.class);
							startActivity(intent);
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
		NewsData model1 = new NewsData();
		model1.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507887527&di=6a320a3aa3784d44902780c1b90eaad2&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D7dde8a793ea85edfee81f660213d6356%2F8cb1cb13495409231cbb80579858d109b2de49cd.jpg");
		model1.setContent("习近平访问北京海淀区西二旗智学苑四号楼706室");
		list.add(model1);

		NewsData model2 = new NewsData();
		model2.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657473&di=e5b2ed635300e2a0d21fdfe7553120f9&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb999a9014c086e062d68efaf08087bf40bd1cb16.jpg");
		model2.setContent("习近平访问北京海淀区西二旗智学苑四号楼705室");
		list.add(model2);

		NewsData model3 = new NewsData();
		model3.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657472&di=601d1d09e88f1d24ccbdf1def07e8973&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd788d43f8794a4c231fca94504f41bd5ac6e3984.jpg");
		model3.setContent("习近平访问北京海淀区西二旗智学苑四号楼704室");
		list.add(model3);

		NewsData model4 = new NewsData();
		model4.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657405&di=15cdf4ca220c6b7212541255a76c45f4&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F1f178a82b9014a909461e9baa1773912b31bee5e.jpg");
		model4.setContent("习近平访问北京海淀区西二旗智学苑四号楼703室");
		list.add(model4);

		NewsData model5 = new NewsData();
		model5.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657404&di=aa19eb928571370ebc181c17250b7c67&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F1f178a82b9014a90e7eb9d17ac773912b21bee47.jpg");
		model5.setContent("习近平访问北京海淀区西二旗智学苑四号楼702室");
		list.add(model5);

		return list;
	}
}
