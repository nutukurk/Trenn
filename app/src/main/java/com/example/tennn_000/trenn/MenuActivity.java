package com.example.tennn_000.trenn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by tennn_000 on 17/07/2015.
 */
public class MenuActivity extends ActionBarActivity implements
View.OnTouchListener{

    private ImageView image_button_1;
    private ImageView image_button_2;
    private ImageView image_button_3;
    private ImageView menu_background;

    protected static String combo = "";
    protected static String savedCombo = "";
    protected static int savedComboCounter = 0;

    static SharedPreferences prefs;
    static SharedPreferences.Editor editor;
    protected static String PREFS_NAME = "prefsName";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        image_button_1 = (ImageView) findViewById(R.id.menu_button_1);
        image_button_2 = (ImageView) findViewById(R.id.menu_button_2);
        image_button_3 = (ImageView) findViewById(R.id.menu_button_3);

        image_button_1.setImageDrawable(getResources().getDrawable(R.drawable.combos));
        image_button_2.setImageDrawable(getResources().getDrawable(R.drawable.create));
        image_button_3.setImageDrawable(getResources().getDrawable(R.drawable.options));

        menu_background = (ImageView) findViewById(R.id.menu_background);
        menu_background.setImageDrawable(getResources().getDrawable(R.drawable.menu_background));

        editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();

//        editor.putString("homeScore", YOUR_HOME_SCORE);
//
//        editor.apply();

// Get from the SharedPreferences
//        prefs = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
//        int homeScore = prefs.getInt("homeScore", 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        image_button_1.setOnTouchListener(this);
        image_button_2.setOnTouchListener(this);
        image_button_3.setOnTouchListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        image_button_1.setOnTouchListener(null);
        image_button_2.setOnTouchListener(null);
        image_button_3.setOnTouchListener(null);
    }



    private Rect rect;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId() == R.id.menu_button_1){
            if(event.getAction() == MotionEvent.ACTION_UP){
                image_button_1.setImageDrawable(getResources().getDrawable(R.drawable.combos));
                if (rect != null && !rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                    return true;
                }
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            } else if(event.getAction() == MotionEvent.ACTION_DOWN){
                rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                image_button_1.setImageDrawable(getResources().getDrawable(R.drawable.combos_pressed));
                return true;
            }
        }

        if(v.getId() == R.id.menu_button_2){
            if(event.getAction() == MotionEvent.ACTION_UP){
                image_button_2.setImageDrawable(getResources().getDrawable(R.drawable.create));
                if (rect != null && !rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                    return true;
                }
                Intent intent = new Intent(this, ResultActivity.class);
                startActivity(intent);
                return true;

            } else if(event.getAction() == MotionEvent.ACTION_DOWN){
                rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                image_button_2.setImageDrawable(getResources().getDrawable(R.drawable.create_pressed));
                return true;
            }
        }

        if(v.getId() == R.id.menu_button_3){
            if(event.getAction() == MotionEvent.ACTION_UP){
                image_button_3.setImageDrawable(getResources().getDrawable(R.drawable.options));
                if (rect != null && !rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                    return true;
                }
                //Intent intent = new Intent(this, MainActivity.class);
                //startActivity(intent);
                return true;

            } else if(event.getAction() == MotionEvent.ACTION_DOWN){
                rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                image_button_3.setImageDrawable(getResources().getDrawable(R.drawable.options_pressed));
                return true;
            }
        }
        return false;
    }


}
