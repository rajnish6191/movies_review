package com.android.androidproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Questions extends Activity {

	Chronometer ch;
	RadioButton ans1, ans2, ans3, ans4;
	Button bSubmit, bSkip;
	String jsondata;
	TextView tv;
	int ii;
	int j = 0, k = 0;
	ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
	String uans;

	JSONArray questi = null;
	private static final String questions = "questions";
	private static final String ID = "id";
	private static final String question = "question";
	private static final String option1 = "option1";
	private static final String option2 = "option2";
	private static final String option3 = "option3";
	private static final String option4 = "option4";
	private static final String correctans = "Correctans";

@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// ---Hiding titlebar---
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.questions);

		final RadioGroup radiogrp = (RadioGroup) findViewById(R.id.radioGroup1);
		tv = (TextView) findViewById(R.id.tvQues1);
		ans1 = (RadioButton) findViewById(R.id.op1);
		ans2 = (RadioButton) findViewById(R.id.op2);
		ans3 = (RadioButton) findViewById(R.id.op3);
		ans4 = (RadioButton) findViewById(R.id.op4);
		bSubmit = (Button) findViewById(R.id.bnext);
		bSkip = (Button) findViewById(R.id.bSkip);
		ch = (Chronometer) findViewById(R.id.mChronomete);
		
		ch.start();

		for (int i = 0; i < 5; i++) {
			while (true) {
				Random random = new Random();
				int ii = random.nextInt(20);

				if (!arrayList.contains(ii)) {
					arrayList.add(ii);

					break;
				}
			}
		}
Log.e("random1", Integer.toString(arrayList.get(0)));
		Log.e("random2", Integer.toString(arrayList.get(1)));
		Log.e("random3", Integer.toString(arrayList.get(2)));
		Log.e("random4", Integer.toString(arrayList.get(3)));
		Log.e("random5", Integer.toString(arrayList.get(4)));

		// ArrayList<HashMap<String, String>> contactList = new
		// ArrayList<HashMap<String, String>>();

		Intent intent = getIntent();
		String str = intent.getStringExtra("level");

		try {
			if (str.equalsIgnoreCase("easy")) {
				jsondata = jsonToStringFromAssetFolder("Json.txt",
						getApplicationContext());
				Toast.makeText(getBaseContext(), "Level Easy Selected",
						Toast.LENGTH_SHORT).show();
			} else if (str.equalsIgnoreCase("medium")) {
				jsondata = jsonToStringFromAssetFolder("jason_mid.txt",
						getApplicationContext());
				Toast.makeText(getBaseContext(), "Level Medium Selected",
						Toast.LENGTH_SHORT).show();
			}
			if (str.equalsIgnoreCase("hard")) {
				jsondata = jsonToStringFromAssetFolder("json_hard.txt",
						getApplicationContext());
				Toast.makeText(getBaseContext(), "Level Hard Selected",
						Toast.LENGTH_SHORT).show();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			// Parse the data into jsonobject to get original data in form of
			// json.
			JSONObject json = new JSONObject(jsondata);
			questi = json.getJSONArray(questions);

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
