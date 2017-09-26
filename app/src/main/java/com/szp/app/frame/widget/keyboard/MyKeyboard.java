package com.szp.app.frame.widget.keyboard;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.szp.app.frame.R;

/**
 * Created by sunzeping on 2017/9/26.
 * Function:
 * Desc:
 */
public class MyKeyboard extends LinearLayout {

  private Context mContext;
  private View mView;

  private KeyboardView keyboard_view;
  /**
   * 键盘抬头
   */
  private RelativeLayout security_title_layout;

  public MyKeyboard(Context context) {
    super(context);
    this.mContext = context;
    initView();
  }

  public MyKeyboard(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.mContext = context;
    initView();
  }

  /**
   * 初始化
   */
  private void initView() {
    mView = LayoutInflater.from(mContext).inflate(R.layout.keyboard_layout, null);
    security_title_layout = (RelativeLayout) mView.findViewById(R.id.security_title_layout);
    keyboard_view = (KeyboardView) mView.findViewById(R.id.keyboard_view);
    security_title_layout.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {

      }
    });
  }

  public void showKeyboard(Activity activity, EditText edit) {
    KeyboardUtil.shared(activity, edit, keyboard_view).showKeyboard();
  }
}
