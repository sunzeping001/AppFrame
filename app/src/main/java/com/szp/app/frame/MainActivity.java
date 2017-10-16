package com.szp.app.frame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.szp.app.frame.activity.BaseActivity;
import com.szp.app.frame.nametest.entity.PersonRequest;
import com.szp.app.frame.nametest.response.PersonResponse;
import com.szp.app.frame.net.NetClient;
import com.szp.app.frame.ui.WelcomeActivity;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
	//	private Button btn;
//	private EditText edit;
//	private MyKeyboard keyboard;
//	private KeyboardView keyboard_view;
	private ImageView imageView;
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			jumpToWelloComeActivity();
		}
	};

	/**
	 * jump to welcome page
	 */
	private void jumpToWelloComeActivity() {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, WelcomeActivity.class);
		startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView) findViewById(R.id.img_full);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Message message = new Message();
				message.what = 0;
				mHandler.sendMessage(message);
			}
		},3000);
	}

	private View.OnClickListener btnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			requestServer();
		}
	};

	private void requestServer() {
		String baseUrl = "http://10.13.42.45:8080/MyJSTest/";
		PersonRequest request = new PersonRequest();
		request.setName("123");
		NetClient netClient = new NetClient(baseUrl);
		netClient.asynPersonQuery(request, new retrofit2.Callback<PersonResponse>() {
			@Override
			public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
				PersonResponse personBaseResponse = (PersonResponse) response.body();
				Log.e("szp", personBaseResponse.getName());
				Log.e("szp", personBaseResponse.getUrl());
			}

			@Override
			public void onFailure(Call call, Throwable t) {
				Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
				Log.e("szp", t.getMessage());
			}
		});
	}
}
