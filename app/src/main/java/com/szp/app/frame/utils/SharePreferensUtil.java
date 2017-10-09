package com.szp.app.frame.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.szp.app.frame.AppAplication;

/**
 * Created by sunzeping on 17/9/29.
 * Function :
 * Desc :
 */

public class SharePreferensUtil {

	public String LOGIN_NAME = "login";
	public String LOGIN_PWD = "pwd";
	private static final String SHARE = "sunzeping";

	/**
	 * save string
	 *
	 * @param key
	 * @param value
	 */
	public static void putString(String key, String value) {
		SharedPreferences sharedPreferences = getSharedPreferences();
		sharedPreferences.edit().putString(key, value).commit();
	}

	/**
	 * get string
	 *
	 * @param key
	 * @return
	 */
	public static String getString(String key, String defaultValue) {
		SharedPreferences sharedPreferences = getSharedPreferences();
		String vaule = sharedPreferences.getString(key, defaultValue);
		return vaule;
	}

	/**
	 * save boolean
	 *
	 * @param key
	 * @param value
	 */
	public static void putBoolean(String key, boolean value) {
		SharedPreferences sharedPreferences = getSharedPreferences();
		sharedPreferences.edit().putBoolean(key, value).commit();
	}

	/**
	 * get boolean
	 *
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(String key, boolean defalutBoolean) {
		SharedPreferences sharedPreferences = getSharedPreferences();
		boolean value = sharedPreferences.getBoolean(key, defalutBoolean);
		return value;
	}

	/**
	 * save string
	 *
	 * @param key
	 * @param value
	 */
	public static void putInt(String key, int value) {
		SharedPreferences sharedPreferences = getSharedPreferences();
		sharedPreferences.edit().putInt(key, value).commit();
	}

	/**
	 * get string
	 *
	 * @param key
	 * @param defaultVaule
	 * @return
	 */
	public static int getInt(String key, int defaultVaule) {
		SharedPreferences sharedPreferences = getSharedPreferences();
		int value = sharedPreferences.getInt(key, defaultVaule);
		return value;
	}

	/**
	 * get SharedPreferences
	 *
	 * @return
	 */
	private static SharedPreferences getSharedPreferences() {
		Context context = new AppAplication().getApplicationContext();
		SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE, Context.MODE_PRIVATE);
		return sharedPreferences;
	}
}
