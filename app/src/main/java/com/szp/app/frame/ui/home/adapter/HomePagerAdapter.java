package com.szp.app.frame.ui.home.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by sunzeping on 17/10/3.
 * Function :
 * Desc :
 */

public class HomePagerAdapter extends PagerAdapter {

	private List<ImageView> imageViewList;

	public HomePagerAdapter(List<ImageView> imageViewList) {
		this.imageViewList = imageViewList;
	}

	@Override
	public int getCount() {
		return imageViewList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(imageViewList.get(position));
		return imageViewList.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(imageViewList.get(position));
	}
}
