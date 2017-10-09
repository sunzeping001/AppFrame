package com.szp.app.frame.widget.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.szp.app.frame.R;
import com.szp.app.frame.utils.MD5EncroyTool;

/**
 * Created by sunzeping on 17/10/1.
 * Function : login widget
 * Desc :
 */

public class LoginWidget extends LinearLayout {

	private Context mContext;
	private View mView;

	private EditText edit_name;
	private EditText edit_pwd;
	private Button btn_login;
	private LoginListener mLoginListener;

	public LoginWidget(Context context) {
		super(context);
		this.mContext = context;
		initView();
	}

	public LoginWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		initView();
	}

	/**
	 * 初始化
	 */
	private void initView() {
		mView = LayoutInflater.from(mContext).inflate(R.layout.login_widget, this, true);
		edit_name = (EditText) mView.findViewById(R.id.edit_name);
		edit_pwd = (EditText) mView.findViewById(R.id.edit_pwd);
		btn_login = (Button) mView.findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mLoginListener.onClick();
			}
		});
	}

	/**
	 * get user name
	 *
	 * @return
	 */
	public String getUserName() {
		if (!TextUtils.isEmpty(edit_name.getText().toString())) {
			return MD5EncroyTool.md5(edit_name.getText().toString());
		} else {
			return "";
		}
	}

	/**
	 * get user pwd
	 * @return
	 */
	public String getPwd() {
		if (!TextUtils.isEmpty(edit_pwd.getText().toString())) {
			return MD5EncroyTool.md5(edit_name.getText().toString());
		} else {
			return "";
		}
	}

	public void setLoginListener(LoginListener loginListener) {
		this.mLoginListener = loginListener;
	}

	public interface LoginListener {
		void onClick();
	}
}
