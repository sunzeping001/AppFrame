package com.szp.app.frame.ui.home.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.szp.app.frame.R;

import java.util.ArrayList;

/**
 * Created by sunzeping on 17/10/3.
 * Function :
 * Desc :
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

	private ArrayList<String> mData;
	private Context mContext;

	public HomeRecyclerAdapter(ArrayList<String> data,Context context) {
		this.mContext = context;
		this.mData = data;
	}

	public void updateData(ArrayList<String> data) {
		this.mData = data;
		notifyDataSetChanged();
	}

	@Override
	public HomeRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// 实例化展示的view
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
		// 实例化viewholder
		HomeRecyclerAdapter.ViewHolder viewHolder = new com.szp.app.frame.ui.home.adapter.HomeRecyclerAdapter.ViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(HomeRecyclerAdapter.ViewHolder holder, int position) {
		// 绑定数据
		holder.mTv.setText(mData.get(position));
		Picasso.with(mContext).load(Uri.parse(mData.get(position))).into(holder.mImg);
	}

	@Override
	public int getItemCount() {
		return mData == null ? 0 : mData.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		TextView mTv;
		ImageView mImg;

		public ViewHolder(View itemView) {
			super(itemView);
			mTv = (TextView) itemView.findViewById(R.id.item_tv);
			mImg = (ImageView) itemView.findViewById(R.id.item_img);
		}
	}

}

