package com.szp.app.frame.ui.guanzhu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseFragment;
import com.szp.app.frame.ui.guanzhu.adapter.GuanzhuAdapter;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuModel;
import com.szp.app.frame.ui.guanzhu.presenter.IGuanzhuContract;

import java.util.List;

/**
 * Created by sunzeping on 17/10/22.
 * Function :
 * Desc :
 */

public class GuanzhuFragment extends BaseFragment implements IGuanzhuContract.IView {

	private View mView;

	private IGuanzhuContract.IPresenter mPresenter;

	private RecyclerView recyclerView;

	private GuanzhuAdapter guanzhuAdapter;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mView = LayoutInflater.from(mActivity).inflate(R.layout.guanzhu_fragment_layout, null);
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
	public void initData(List<GuanzhuModel> list) {
		guanzhuAdapter = new GuanzhuAdapter(list, mActivity);

	}

	@Override
	public void initView() {
		recyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
		recyclerView.setAdapter(guanzhuAdapter);
	}

	@Override
	public void setPresenter(IGuanzhuContract.IPresenter presenter) {
		this.mPresenter = presenter;
	}


}
