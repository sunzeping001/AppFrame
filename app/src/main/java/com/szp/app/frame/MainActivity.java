package com.szp.app.frame;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.szp.app.network.client.AbstractNetClientFactory;
import com.szp.app.network.client.INetClient;
import com.szp.app.network.client.RetrofitNetClientFactory;
import com.szp.app.network.requests.PersonRequest;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends Activity {
  private Button btn;
  private Handler mHandler = new Handler() {
    @Override public void handleMessage(Message msg) {
      if (msg.what == 0) {
        new Thread(new Runnable() {
          @Override public void run() {
            requestServer();
          }
        }).start();
      }
    }
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn = (Button) findViewById(R.id.btn);
    btn.setOnClickListener(btnClickListener);
  }

  private View.OnClickListener btnClickListener = new View.OnClickListener() {
    @Override public void onClick(View view) {

      //mHandler.postDelayed(new Runnable() {
      //  @Override public void run() {
      //    Message message = new Message();
      //    message.what = 0;
      //    mHandler.sendMessage(message);
      //  }
      //}, 1000);
      requestServer();
    }
  };

  private void requestServer(){
    String baseUrl = "http://192.168.0.108:8080/welcome/";
    INetClient netClient =
        AbstractNetClientFactory.getFactory(RetrofitNetClientFactory.class)
            .getNetClient(baseUrl);
    PersonRequest request = new PersonRequest();
    request.setId("123");
    netClient.asynRequest(request, new retrofit2.Callback() {
      @Override public void onResponse(Call call, Response response) {
        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
      }

      @Override public void onFailure(Call call, Throwable t) {
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("szp", t.getMessage());
      }
    });
  }

}
