package com.szp.app.frame.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by sunzeping on 17/10/2.
 * Function :
 * Desc :
 */

public class BaseFragment extends Fragment {

	protected Activity mActivity;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = getActivity();
	}
}
