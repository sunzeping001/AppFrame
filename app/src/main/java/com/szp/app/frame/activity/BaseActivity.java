package com.szp.app.frame.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.szp.app.frame.R;
import com.szp.app.frame.commdata.BaseData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzeping on 17/9/14.
 * Function :
 * Desc :
 */

public class BaseActivity extends FragmentActivity {

	protected BaseData mBaseData;

	private List<Activity> mListActivities;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mListActivities = new ArrayList<>();
		addListActivity(this);
	}

	private void addListActivity(Activity activity) {
		mListActivities.add(activity);
	}

	public void exitApp() {
		if (mListActivities != null && mListActivities.size() > 0) {
			for (int i = 0; i < mListActivities.size(); i++) {
				mListActivities.get(i).finish();
			}
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	/**
	 * 切换fragment
	 */
	public void startFirstFragment(Fragment fragment) {

		if (isFinishing()) {
			return;
		}
		if (Build.VERSION.SDK_INT > 16 && isDestroyed()) {
			return;
		}
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.setCustomAnimations(R.anim.fragment_right_in, R.anim.fragment_left_out,
				R.anim.fragment_left_in, R.anim.fragment_right_out);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.replace(R.id.layout_content, fragment);
		ft.commitAllowingStateLoss();
	}

	/**
	 * 启动做滑动动画fragment
	 */
	public void startFragment(Fragment fragment) {

		if (isFinishing()) {
			return;
		}
		if (Build.VERSION.SDK_INT > 16 && isDestroyed()) {
			return;
		}
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.setCustomAnimations(R.anim.fragment_right_in, R.anim.fragment_left_out,
				R.anim.fragment_left_in, R.anim.fragment_right_out);
		ft.replace(R.id.layout_content, fragment, fragment.getClass().getName());
		ft.addToBackStack(fragment.getClass().getName());
		ft.commitAllowingStateLoss();
	}

	@Override
	public void onBackPressed() {

	}
}
