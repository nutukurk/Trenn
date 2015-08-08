package com.example.tennn_000.trenn;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tennn_000 on 17/07/2015.
 */
public class ResultActivity extends ActionBarActivity {

    private TextView save_text;
    private ImageView create_combos_backgroundtwo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Log.d("kenno", "RESULT ACTIVITY CREATED!!!");
        Typeface mytypeface = Typeface.createFromAsset(getAssets(), "snowstorm.otf");
        TextView mytextview = (TextView)findViewById(R.id.result_text);
        save_text = (TextView) findViewById(R.id.result_text);
        mytextview.setTypeface(mytypeface);


        create_combos_backgroundtwo = (ImageView) findViewById(R.id.create_combos_backgroundtwo);
        create_combos_backgroundtwo.setImageDrawable(getResources().getDrawable(R.drawable.carbon_background));




//        Log.d("kenno", "combo text: " + MenuActivity.combo);
//        if(savedCombo != null){
//            savedCombo = savedCombo + MenuActivity.combo;
//        } else {
//            savedCombo = MenuActivity.combo;
//        }
//
//        //MenuActivity.combo = "";
//        savedCombo = (savedCombo + "\n\n");
        MenuActivity.prefs = getApplicationContext()
                .getSharedPreferences(MenuActivity.PREFS_NAME, MODE_PRIVATE);

//        save_text.setText(MenuActivity.savedCombo);
        save_text.setText(MenuActivity.prefs.getString("combos", MenuActivity.savedCombo));
    }


}

