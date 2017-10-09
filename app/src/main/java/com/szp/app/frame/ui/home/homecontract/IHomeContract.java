package com.szp.app.frame.ui.home.homecontract;

import android.app.Activity;
import android.widget.ImageView;

import com.szp.app.frame.BasePresenter;
import com.szp.app.frame.BaseView;

import java.util.List;

/**
 * Created by sunzeping on 17/10/2.
 * Function : home fragment contract
 * Desc :
 */

public interface IHomeContract {

	interface IView extends BaseView<IPresenter> {

		void initViewPager(List<ImageView> list);

		Activity getParentActivity();
	}

	interface IPresenter extends BasePresenter {

	}
}
