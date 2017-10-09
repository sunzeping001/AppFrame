package com.szp.app.frame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.szp.app.frame.activity.BaseActivity;
import com.szp.app.frame.utils.DESEncroyTool;
import com.szp.app.frame.widget.keyboard.MyKeyboard;

/**
 * Created by sunzeping on 17/9/30.
 * Function :
 * Desc :
 */

public class TestActivity extends BaseActivity {

	private EditText edit_prk;
	private EditText edit_content;
	private EditText edit_encry;
	private Button btn_encry;
	private Button btn_decode;
	private byte[] key;

	private MyKeyboard myKeyboard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_layout);
		edit_prk = (EditText) findViewById(R.id.edit_prk);
		edit_content = (EditText) findViewById(R.id.edit_content);
		edit_encry = (EditText) findViewById(R.id.edit_encry);
		btn_encry = (Button) findViewById(R.id.btn_encry);
		btn_decode = (Button) findViewById(R.id.btn_decode);
		edit_content.setText("这就是要加密的东西");
		myKeyboard = (MyKeyboard) findViewById(R.id.keyboard);
		myKeyboard.initKeyboard(TestActivity.this,edit_content);
		edit_content.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				myKeyboard.setVisibility(View.VISIBLE);
				myKeyboard.showKeyboard();
			}
		});
		key = DESEncroyTool.generateKey();
		btn_encry.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					String encode = DESEncroyTool.encrypt3DES(edit_content.getText().toString().getBytes("utf-8"), key);
					edit_encry.setText(encode);
					Log.e("szp", encode);
				} catch (Exception ex) {

				}

			}
		});
		btn_decode.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					String decode = DESEncroyTool.decrypt3DES(edit_encry.getText().toString(), key);
					edit_prk.setText(decode);

				} catch (Exception ex) {

				}
			}
		});

	}
}
