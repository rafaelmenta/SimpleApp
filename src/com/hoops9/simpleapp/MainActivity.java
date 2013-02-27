package com.hoops9.simpleapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	ImageButton button;
	int currentBackground = android.R.drawable.btn_star_big_off;
	MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mediaPlayer = MediaPlayer.create(this, R.raw.test_music);
		addListenerOnButton();

	}
	
	@SuppressLint("NewApi")
	public void addListenerOnButton() {
		button = (ImageButton) findViewById(R.id.imageButton1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// mediaPlayer.start();
				if (android.R.drawable.btn_star_big_off == currentBackground) {
					currentBackground = android.R.drawable.btn_star_big_on;
				} else {
					currentBackground = android.R.drawable.btn_star_big_off;
				}
				button.setImageResource(currentBackground);
			}
		});
		
		button.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_MOVE) {
					button.setX(button.getX() + event.getX());
					button.setY(button.getY() + event.getY());
				}
				
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
