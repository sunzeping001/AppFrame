package com.szp.app.frame.ui.news.newscontract;

import android.app.Activity;

import com.szp.app.frame.BasePresenter;
import com.szp.app.frame.BaseView;
import com.szp.app.frame.ui.news.model.NewsData;

import java.util.List;

/**
 * Created by sunzeping on 17/10/6.
 * Function : 新闻的协议接口类
 * Desc :
 */

public interface INewsContract {

	interface IView extends BaseView<IPresenter>{
		void initView();

		Activity getParentActivity();



	}

	interface IPresenter extends BasePresenter{
		/**
		 * 获取数据
		 * @return
		 */
		List<NewsData> getData();
	}
}
