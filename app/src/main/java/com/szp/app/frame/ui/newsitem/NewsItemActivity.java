package com.szp.app.frame.ui.newsitem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseActivity;

public class NewsItemActivity extends BaseActivity {

  private ImageView mImageView;

  private TextView mTextView;

  public static String URL = "url";

  public static String CONTENT = "content";

  private String mUrl;
  private String mContent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news_item);
    initData();
    initView();
  }

  /**
   * init data
   */
  private void initData() {
    Intent intent = getIntent();
    mUrl = intent.getStringExtra(URL);
    mContent = intent.getStringExtra(CONTENT);
  }

  /**
   * init view
   */
  private void initView() {
    mImageView = (ImageView) findViewById(R.id.item_img);
    mTextView = (TextView) findViewById(R.id.item_content);
    Picasso.with(this).load(Uri.parse(mUrl)).into(mImageView);
    mTextView.setText("        " + mContent);
  }

}
