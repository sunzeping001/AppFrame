package com.szp.app.frame.ui.toutiao.presenter;

import com.szp.app.frame.BasePresenter;
import com.szp.app.frame.BaseView;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuListModel;

/**
 * Created by sunzeping on 17/10/21.
 * Function : 模仿头条的prensenter的协议类
 * Desc :
 */

public interface ITouTiaoPresenterContract {

	interface IView extends BaseView<IPresenter> {
		void initData();
	}

	interface IPresenter extends BasePresenter {

		GuanzhuListModel getGuanhuData();
	}

}
