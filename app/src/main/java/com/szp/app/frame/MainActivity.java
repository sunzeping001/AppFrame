package com.szp.app.frame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.szp.app.frame.activity.BaseActivity;
import com.szp.app.frame.ui.login.LoginActivity;

public class MainActivity extends BaseActivity {
  private ImageView imageView;
  private final int SWITCH = 3000;
  private Handler mHandler = new Handler() {
    @Override public void handleMessage(Message msg) {
      jumpToWelloComeActivity();
    }
  };

  /**
   * jump to welcome page
   */
  private void jumpToWelloComeActivity() {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, LoginActivity.class);
    startActivity(intent);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    imageView = (ImageView) findViewById(R.id.img_full);
  }

  @Override protected void onResume() {
    super.onResume();
    mHandler.postDelayed(new Runnable() {
      @Override public void run() {
        Message message = new Message();
        message.what = 0;
        mHandler.sendMessage(message);
      }
    }, SWITCH);
  }

  //private View.OnClickListener btnClickListener = new View.OnClickListener() {
  //  @Override public void onClick(View view) {
  //    requestServer();
  //  }
  //};
  //
  //private void requestServer() {
  //  String baseUrl = "http://10.13.42.45:8080/MyJSTest/";
  //  final PersonRequest request = new PersonRequest();
  //  request.setName("123");
  //  NetClient netClient = new NetClient(baseUrl);
  //  netClient.asynQuery(request, new IResultCallback<PersonResponse>() {
  //    @Override public void onSuccess(PersonResponse response) {
  //      Log.e("szp",response.toString());
  //    }
  //
  //    @Override public void onFail(String errorCode, String errorMsg) {
  //    }
  //  });
  //}
}
