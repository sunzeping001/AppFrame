package com.szp.app.frame;

/**
 * Created by sunzeping on 17/10/3.
 * Function :
 * Desc :
 */

public interface BaseView<T extends BasePresenter> {

	void initView();

	void setPresenter(T presenter);

}
