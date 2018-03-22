package com.domobile.dimobile_test.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 *description:SharePreference操作类
 *author:zhua
 *creator at:2018/3/22
 */
public class UserPreferences {
	private static SharedPreferences preferences;
	private final static String mSharedPreferencesFileName = "Setting";

	private UserPreferences() {
	}
	
	public static void saveInt(Context context, String key, Integer value ) {
		preferences = context.getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE );
		Editor edit = preferences.edit();
		edit.putInt( key, value );
		edit.commit();
	}

	public static int loadInt(Context context, String key, int defValue ) {
		preferences = context.getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE );
		return preferences.getInt( key, defValue );
	}

	public static void saveLong(Context context, String key, long value ) {
		preferences = context.getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE );
		Editor edit = preferences.edit();
		edit.putLong(key, value);
		edit.commit();
	}

	public static long loadLong(Context context, String key, long defValue ) {
		preferences = context.getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE );
		return preferences.getLong(key, defValue);
	}

	public static void saveString(Context context, String key, String value ) {
		preferences = context.getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE );
		Editor edit = preferences.edit();
		edit.putString(key, value);
		edit.commit();
	}

	public static String loadString(Context context, String key, String defValue ) {
		preferences = context.getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE );
		return preferences.getString(key, defValue);
	}

	public static void saveBoolean(Context context, String key, boolean value ) {
		preferences = context.getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE );
		Editor edit = preferences.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	public static boolean loadBoolean(Context context, String key, boolean defValue ) {

		if(null == context){
			return false;
		}
		preferences = context.getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE );
		return preferences.getBoolean(key, defValue);
	}

	public static void saveCurrentAccountId(Context context, String key, String value){
		preferences = context.getApplicationContext().getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE);
		Editor edit = preferences.edit();
		edit.putString(key, value);
		edit.commit();
	}

	public static String getCurrentAccountId(Context context, String key, String defValue){
		preferences = context.getApplicationContext().getSharedPreferences(mSharedPreferencesFileName, Context.MODE_PRIVATE);
		return preferences.getString(key, defValue);
	}

}
