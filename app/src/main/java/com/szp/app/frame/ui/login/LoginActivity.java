package com.szp.app.frame.ui.login;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseActivity;
import com.szp.app.frame.net.NetClient;
import com.szp.app.frame.ui.HomeActivity;
import com.szp.app.frame.ui.home.entity.HomeRequest;
import com.szp.app.frame.ui.login.entity.LoginRequest;
import com.szp.app.frame.ui.login.entity.LoginResponse;
import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.widget.login.LoginWidget;
import com.szp.app.network.interf.IResultCallback;
import java.util.List;

public class LoginActivity extends BaseActivity {

  private LoginWidget loginWidget;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
    loginWidget = (LoginWidget) findViewById(R.id.login);
    loginWidget.setLoginListener(new LoginWidget.LoginListener() {
      @Override public void onClick() {
        getLogin();
      }
    });
  }

  /**
   *
   */
  private void getLogin() {
    LoginRequest loginRequest = new LoginRequest();
    loginRequest.setName("小孙哥哥");
    loginRequest.setPwd("123456");
    new NetClient("http://wohenyouqian.com").asynLoginQuery(loginRequest,
        new IResultCallback<LoginResponse>() {
          @Override public void onSuccess(LoginResponse response) {
            Log.e("szp","getLogin = onSuccess & isLogin = " + response);
            jumpToHomeActivity();
          }

          @Override public void onFail(String errorCode, String errorMsg) {
            Log.e("szp","getLogin = onFail");
          }
        });
  }

  /**
   * 跳转到home页面
   */
  private void jumpToHomeActivity() {
    Intent intent = new Intent();
    intent.setClass(LoginActivity.this, HomeActivity.class);
    startActivity(intent);
  }
}
