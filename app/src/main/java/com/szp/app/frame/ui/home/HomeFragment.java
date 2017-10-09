package com.szp.app.frame.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseFragment;
import com.szp.app.frame.ui.home.adapter.HomePagerAdapter;
import com.szp.app.frame.ui.home.adapter.HomeRecyclerAdapter;
import com.szp.app.frame.ui.home.adapter.SpacesItemDecoration;
import com.szp.app.frame.ui.home.anim.DepthPageTransformer;
import com.szp.app.frame.ui.home.homecontract.IHomeContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzeping on 17/10/2.
 * Function : home fragment
 * Desc :
 */

public class HomeFragment extends BaseFragment implements IHomeContract.IView {

	private IHomeContract.IPresenter mPresenter;

	private View mView;

	private ViewPager viewPager;

	private HomePagerAdapter mAdapter;
	private RecyclerView mRecyclerView;

	private RecyclerView.Adapter mRecyclerViewAdapter;

	private RecyclerView.LayoutManager mLayoutManager;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mView = LayoutInflater.from(mActivity).inflate(R.layout.home_fragment_layout, null);
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
		mPresenter.start();
	}

	@Override
	public void setPresenter(IHomeContract.IPresenter presenter) {
		this.mPresenter = presenter;
	}

	@Override
	public void initViewPager(List<ImageView> list) {
		viewPager = (ViewPager) mView.findViewById(R.id.viewPager);
		mAdapter = new HomePagerAdapter(list);
		viewPager.setAdapter(mAdapter);
		viewPager.setPageTransformer(true, new DepthPageTransformer());

		mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		mRecyclerViewAdapter = new HomeRecyclerAdapter(getData(), mActivity);
		mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
		// 设置布局管理器
		mRecyclerView.setLayoutManager(mLayoutManager);
		// 设置adapter
		mRecyclerView.setAdapter(mRecyclerViewAdapter);
		SpacesItemDecoration decoration = new SpacesItemDecoration(16);
		mRecyclerView.addItemDecoration(decoration);

	}

	@Override
	public Activity getParentActivity() {
		return mActivity;
	}

	private ArrayList<String> getData() {
		ArrayList<String> data = new ArrayList<>();
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507887527&di=6a320a3aa3784d44902780c1b90eaad2&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D7dde8a793ea85edfee81f660213d6356%2F8cb1cb13495409231cbb80579858d109b2de49cd.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812232&di=fbeec995866466de75c1671d52037cd5&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F9825bc315c6034a81c94dd93c1134954092376a9.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812229&di=14990b55ded4ce5c4b4caf81c9e7aee8&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fae51f3deb48f8c5491fa743030292df5e0fe7f87.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812228&di=b95ae9f3e128b47f57474e8a9b327acf&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3Df8709c2330f33a878a600859ae357a4d%2Fe850352ac65c10387e0ad1d1b8119313b07e89a8.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812226&di=12c982e0a8668a1ff41b956c33c0151d&imgtype=0&src=http%3A%2F%2Fpic.jj20.com%2Fup%2Fallimg%2F1011%2F112G6002358%2F16112F02358-1.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812225&di=e06779fd0c9681b32043c209d1c866c5&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ff3d3572c11dfa9eca8dd9e1768d0f703918fc13b.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812223&di=3f1dc3d5429f44ed181a497762df21cb&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F9345d688d43f8794dfc53629d81b0ef41bd53afa.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812256&di=b4d7750b9a73757f04ab56c79570f3f6&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F64380cd7912397dd9f3e8e105382b2b7d0a2875a.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812255&di=122652760626b5c28e8b07f0842eae5c&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F37d3d539b6003af3644c1d423f2ac65c1038b61a.jpg");
		data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507292812255&di=f68e41a677062ec6fc03d890bac913ae&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F3%2F546578ae29f46.jpg");

		return data;
	}
}
