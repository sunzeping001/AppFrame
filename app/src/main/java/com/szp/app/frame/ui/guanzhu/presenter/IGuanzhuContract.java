package com.szp.app.frame.ui.guanzhu.presenter;


import android.support.v4.app.Fragment;

import com.szp.app.frame.BasePresenter;
import com.szp.app.frame.BaseView;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuModel;

import java.util.List;

/**
 * Created by sunzeping on 17/10/22.
 * Function :
 * Desc :
 */

public interface IGuanzhuContract {


	interface IView extends BaseView<IPresenter>{
		void initData(List<GuanzhuModel> list);
	}


	interface IPresenter extends BasePresenter{

		List<Fragment> getFragmentListData();

		List<String> getTitles();

	}
}
