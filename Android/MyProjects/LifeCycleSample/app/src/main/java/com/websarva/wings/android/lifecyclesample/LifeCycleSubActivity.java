package com.websarva.wings.android.lifecyclesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * ライフサイクルサンプル
 *
 * 第2画面のアクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class LifeCycleSubActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i("LifeCycleSample", "Sub onCreate() called.");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_cycle_sub);
	}

	@Override
	public void onStart() {
		Log.i("LifeCycleSample", "Sub onStart() called.");
		super.onStart();
	}

	@Override
	public void onRestart() {
		Log.i("LifeCycleSample", "Sub onRestart() called.");
		super.onRestart();
	}

	@Override
	public void onResume() {
		Log.i("LifeCycleSample", "Sub onResume() called.");
		super.onResume();
	}

	@Override
	public void onPause() {
		Log.i("LifeCycleSample", "Sub onPause() called.");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i("LifeCycleSample", "Sub onStop() called.");
		super.onStop();
	}

	@Override
	public void onDestroy() {
		Log.i("LifeCycleSample", "Sub onDestory() called.");
		super.onDestroy();
	}
	public void onButtonClick(View view) {
		finish();
	}
}
