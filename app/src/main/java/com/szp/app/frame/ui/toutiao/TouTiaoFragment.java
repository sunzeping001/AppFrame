package com.szp.app.frame.ui.toutiao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseFragment;
import com.szp.app.frame.ui.guanzhu.GuanzhuFragment;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuListModel;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuModel;
import com.szp.app.frame.ui.guanzhu.presenter.GuanzhuPresenterImpl;
import com.szp.app.frame.ui.toutiao.adapter.TouTiaoAdapter;
import com.szp.app.frame.ui.toutiao.presenter.ITouTiaoPresenterContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzeping on 17/10/21.
 * Function : 模仿头条的页面内容
 * Desc :
 */

public class TouTiaoFragment extends BaseFragment implements ITouTiaoPresenterContract.IView {
	/**
	 * 加载的布局view
	 */
	private View mView;

	private ITouTiaoPresenterContract.IPresenter mPresenter;

	private ViewPager viewPager;

	private TouTiaoAdapter touTiaoAdapter;

	private LinearLayout layout_icon;

	private List<Fragment> fragmentList;

	private List<String> titles;

	private int index = 0;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mView = LayoutInflater.from(mActivity).inflate(R.layout.toutiao_fragment_layout, null);
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
	public void initData() {
		fragmentList = new ArrayList<>();
		titles = new ArrayList<>();
		//添加关注页面
		setGuanzhuFragment();
		//设置热点
		setHotFragment();
		//设置热点
		setHotFragment();
		//设置热点
		setHotFragment();
	}

	@Override
	public void initView() {
		layout_icon = (LinearLayout) mView.findViewById(R.id.layout_icon);
		addIcon();
		viewPager = (ViewPager) mView.findViewById(R.id.viewPager);
		touTiaoAdapter = new TouTiaoAdapter(getChildFragmentManager(), fragmentList, titles);
		viewPager.setAdapter(touTiaoAdapter);
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				changeIndex(position);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
		viewPager.setCurrentItem(index);
		changeIndex(index);
	}

	/**
	 * 处理索引变动
	 *
	 * @param index
	 */
	private void changeIndex(int index) {
		this.index = index;
		for (int i = 0; i < layout_icon.getChildCount(); i++) {
			TextView textView = (TextView) layout_icon.getChildAt(i);
			if (index == i) {
				textView.setSelected(true);
			} else {
				textView.setSelected(false);
			}

		}
	}

	/**
	 * 添加标题头
	 */
	private void addIcon() {
		for (int i = 0; i < titles.size(); i++) {
			TextView textView = new TextView(mActivity);
			textView.setTextSize(18);
			textView.setTextColor(getResources().getColor(R.color.myblack));
			textView.setBackground(getResources().getDrawable(R.drawable.toutiao_title_icon_selector));
			textView.setText(titles.get(i));
			textView.setGravity(Gravity.CENTER);
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(180, LinearLayout.LayoutParams.WRAP_CONTENT);
			layoutParams.gravity = Gravity.CENTER;
			layoutParams.setMargins(0, 6, 0, 6);
			textView.setLayoutParams(layoutParams);
			layout_icon.addView(textView);
		}
	}

	@Override
	public void setPresenter(ITouTiaoPresenterContract.IPresenter presenter) {
		this.mPresenter = presenter;
	}

	/**
	 * 设置关注页面
	 */
	private void setGuanzhuFragment(){
		GuanzhuListModel guanzhuListModel = new GuanzhuListModel();
		List<GuanzhuModel> list = new ArrayList<>();
		GuanzhuFragment guanzhuFragment = new GuanzhuFragment();
		for (int i = 0; i < 7; i++) {
			GuanzhuModel guanzhuModel = new GuanzhuModel();
			guanzhuModel.setTitle("小孙哥哥荣获感动中国第201" + i + "最感动人物");
			guanzhuModel.setContent("央视新闻网提供");
			guanzhuModel.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508688610664&di=568a6b056c53abe916aa66238e6fcdab&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3Dc803822dc295d143ce7bec601b99e877%2Fac4bd11373f08202d00bff1141fbfbedab641b06.jpg");
			list.add(guanzhuModel);
		}
		guanzhuListModel.setGuanzhuModelList(list);
		new GuanzhuPresenterImpl(guanzhuFragment,guanzhuListModel);
		fragmentList.add(guanzhuFragment);
		titles.add("关注");
	}

	/**
	 * 设置热点页面
	 */
	private void setHotFragment(){
		GuanzhuListModel guanzhuListModel = new GuanzhuListModel();
		List<GuanzhuModel> list = new ArrayList<>();
		GuanzhuFragment guanzhuFragment = new GuanzhuFragment();
		for (int i = 0; i < 7; i++) {
			GuanzhuModel guanzhuModel = new GuanzhuModel();
			guanzhuModel.setTitle("小孙哥哥荣获感动中国第201" + i + "最感动人物");
			guanzhuModel.setContent("央视新闻网提供");
			guanzhuModel.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508688610664&di=568a6b056c53abe916aa66238e6fcdab&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3Dc803822dc295d143ce7bec601b99e877%2Fac4bd11373f08202d00bff1141fbfbedab641b06.jpg");
			list.add(guanzhuModel);
		}
		guanzhuListModel.setGuanzhuModelList(list);
		new GuanzhuPresenterImpl(guanzhuFragment,guanzhuListModel);
		fragmentList.add(guanzhuFragment);
		titles.add("热点");
	}


}