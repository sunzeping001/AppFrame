package com.szp.app.frame;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.szp.app.network.client.INetClient;
import com.szp.app.network.client.RetrofitNetClient;
import com.szp.app.network.client.RetrofitNetClientFactory;
import com.szp.app.network.requests.PersonRequest;

public class MainActivity extends Activity {
	private Button btn;
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 0){
				new Thread(new Runnable() {
					@Override
					public void run() {
						String url = "http://192.168.0.108:8080/welcome/";
						String path = "TestPerson";
						INetClient netClient = new RetrofitNetClientFactory().getNetClient(url);
						PersonRequest request = new PersonRequest();
						request.setId("123");
//						PersonBaseResponse response = (PersonBaseResponse) netClient.syncRequest(request);
						netClient.asynRequest(request);
					}
				}).start();
			}

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(btnClickListener);
	}

	private View.OnClickListener btnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {

			mHandler.postDelayed(new Runnable() {
				@Override
				public void run() {
					Message message = new Message();
					message.what = 0;
					mHandler.sendMessage(message);
				}
			},1000);
		}
	};
}
