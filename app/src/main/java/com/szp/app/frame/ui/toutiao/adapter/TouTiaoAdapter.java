package com.szp.app.frame.ui.toutiao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by sunzeping on 17/10/22.
 * Function :
 * Desc :
 */

public class TouTiaoAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragmentList;

	private List<String> titleList;

	public TouTiaoAdapter(FragmentManager fm, List<Fragment> list, List<String> titleList) {
		super(fm);
		this.fragmentList = list;
		this.titleList = titleList;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titleList.get(position);
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentList.get(position);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}
}
