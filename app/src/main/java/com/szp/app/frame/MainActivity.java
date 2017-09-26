package com.szp.app.frame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.szp.app.frame.nametest.entity.PersonRequest;
import com.szp.app.frame.nametest.response.PersonResponse;
import com.szp.app.frame.net.NetClient;
import com.szp.app.frame.widget.keyboard.MyKeyboard;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends Activity {
  private Button btn;
  private EditText edit;
  private MyKeyboard keyboard;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn = (Button) findViewById(R.id.btn);
    keyboard = (MyKeyboard) findViewById(R.id.keyboard);
    btn.setOnClickListener(btnClickListener);
    edit = (EditText) findViewById(R.id.edit);
    edit.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //KeyboardUtil.shared(MainActivity.this,edit).showKeyboard();
        keyboard.showKeyboard(MainActivity.this,edit);
      }
    });

  }

  private View.OnClickListener btnClickListener = new View.OnClickListener() {
    @Override public void onClick(View view) {
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

      @Override public void onFailure(Call call, Throwable t) {
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("szp", t.getMessage());
      }
    });
  }
}
