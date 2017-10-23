package com.szp.app.frame.ui.guanzhu.adapter;

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
import com.szp.app.frame.ui.guanzhu.model.GuanzhuModel;

import java.util.List;

/**
 * Created by sunzeping on 17/10/22.
 * Function :
 * Desc :
 */

public class GuanzhuAdapter extends RecyclerView.Adapter<GuanzhuAdapter.ViewHolder> {

	private List<GuanzhuModel> mData;
	private Context mContext;

	public GuanzhuAdapter(List<GuanzhuModel> data, Context context) {
		this.mContext = context;
		this.mData = data;
	}

	public void updateData(List<GuanzhuModel> data) {
		this.mData = data;
		notifyDataSetChanged();
	}

	@Override
	public GuanzhuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// 实例化展示的view
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.guanzhu_fragment_recycle_view_layout, parent, false);
		// 实例化viewholder
		GuanzhuAdapter.ViewHolder viewHolder = new GuanzhuAdapter.ViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(GuanzhuAdapter.ViewHolder holder, int position) {
		// 绑定数据
		holder.tv_title.setText(mData.get(position).getTitle());
		holder.tv_content.setText(mData.get(position).getContent());
		Picasso.with(mContext).load(Uri.parse(mData.get(position).getUrl())).into(holder.img_pic);
	}

	@Override
	public int getItemCount() {
		return mData == null ? 0 : mData.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		TextView tv_title;
		TextView tv_content;
		ImageView img_pic;

		public ViewHolder(View itemView) {
			super(itemView);
			tv_title = (TextView) itemView.findViewById(R.id.tv_title);
			tv_content = (TextView) itemView.findViewById(R.id.tv_content);
			img_pic = (ImageView) itemView.findViewById(R.id.img_pic);
		}
	}
}
