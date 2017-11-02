package com.szp.app.frame;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;


/**
 * Created by sunzeping on 17/9/29.
 * Function : 实现了ReactApplication类的
 * Desc :
 */

public class AppAplication extends Application implements ReactApplication {

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public ReactNativeHost getReactNativeHost() {
		return null;
	}
}
