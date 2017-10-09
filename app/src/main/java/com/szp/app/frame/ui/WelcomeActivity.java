package com.szp.app.frame.ui;

import android.content.Intent;
import android.os.Bundle;

import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseActivity;
import com.szp.app.frame.widget.login.LoginWidget;

public class WelcomeActivity extends BaseActivity {

	private LoginWidget loginWidget;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		loginWidget = (LoginWidget) findViewById(R.id.login);
		loginWidget.setLoginListener(new LoginWidget.LoginListener() {
			@Override
			public void onClick() {
				Intent intent = new Intent();
				intent.setClass(WelcomeActivity.this,HomeActivity.class);
				startActivity(intent);
			}
		});
	}
}
