package com.example.tennn_000.trenn;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tennn_000 on 17/07/2015.
 */
public class ResultActivity extends ActionBarActivity implements View.OnTouchListener{

    private TextView save_text;
    private ImageView create_combos_backgroundtwo;
    private LinearLayout result_combos_linear_layout;
    String[] comboList;
    Typeface mytypeface;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Log.d("kenno", "RESULT ACTIVITY CREATED!!!");
        mytypeface = Typeface.createFromAsset(getAssets(), "snowstorm.otf");

        create_combos_backgroundtwo = (ImageView) findViewById(R.id.create_combos_backgroundtwo);
        create_combos_backgroundtwo.setImageDrawable(getResources().getDrawable(R.drawable.carbon_background));

        result_combos_linear_layout = (LinearLayout) findViewById(R.id.result_combos_linear_layout);

        MenuActivity.prefs = getApplicationContext()
                .getSharedPreferences(MenuActivity.PREFS_NAME, MODE_PRIVATE);

        comboList = MenuActivity.prefs.getString("combos", MenuActivity.savedCombo).split("split");
        //String[] comboList = {"kana","kukk","siga","konn"};

        //System.out.println("combolist len: " + comboList.length);
        Log.d("kenno","combolist len: " + comboList.length);

        for (int i = 0; i < comboList.length; i++) {
            Log.d("kenno","comboList item nr " + i + ": " + comboList[i]);

            if(comboList.length > 0 && !comboList[i].equals("")){
                TextView textView = new TextView(this);
                textView.setText((i+1) + ": \n" + comboList[i]);
                textView.setTextSize(24);
                textView.setTextColor(getResources().getColor(android.R.color.white));
                textView.setTypeface(mytypeface);
                textView.setId(i);
                textView.setOnTouchListener(this);
                result_combos_linear_layout.addView(textView);
            }
        }
    }

    private Rect rect;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("kenno","view's id: " + v.getId());
        if(event.getAction() == MotionEvent.ACTION_UP){
            if (rect != null && !rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                return true;
            }
            setAlphaForView(v, 1.0f);

            v.setVisibility(View.GONE);
            String temporaryComboString = "";
            int deletedComboIndex = Integer.parseInt(String.valueOf(((TextView) v).getText().charAt(0)));
            Log.d("kenno","deletedComboIndex: " + deletedComboIndex);
            int comboIndex;

            for (int i = 0; i < comboList.length; i++) {

                View textView = findViewById(i);

                if(i != v.getId() && textView != null){

                    Log.d("kenno","getText().charAt(0): " + String.valueOf((((TextView) textView)
                            .getText().charAt(0))));
                    if(deletedComboIndex < Integer.parseInt(String.valueOf((((TextView) textView)
                            .getText().charAt(0))))){
                        comboIndex = Integer.parseInt(String.valueOf((((TextView) textView)
                                .getText().charAt(0)))) - 1;
                    } else{
                        comboIndex = Integer.parseInt(String.valueOf((((TextView) textView)
                                .getText().charAt(0))));
                    }

                    ((TextView) textView).setText("");
                    ((TextView) textView).setText(comboIndex + ": \n" + comboList[i]);
                    temporaryComboString = temporaryComboString + comboList[i] + "split";
                }
            }

            View view = findViewById(v.getId());
            ((ViewGroup) view.getParent()).removeView(view);

            Log.d("kenno","temporaryComboString: " + temporaryComboString);

            MenuActivity.savedCombo = temporaryComboString;

            MenuActivity.editor.putString("combos", temporaryComboString);

            MenuActivity.editor.commit();

            return true;

        } else if(event.getAction() == MotionEvent.ACTION_DOWN){
            rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
            setAlphaForView(v, 0.5f);
            return true;
        } else if(event.getAction() == MotionEvent.ACTION_CANCEL){
            setAlphaForView(v, 1.0f);
            return true;
        }
        return false;
    }

    private void setAlphaForView(View v, float alpha) {
        AlphaAnimation animation = new AlphaAnimation(alpha, alpha);
        animation.setDuration(0);
        animation.setFillAfter(true);
        v.startAnimation(animation);
    }
}

