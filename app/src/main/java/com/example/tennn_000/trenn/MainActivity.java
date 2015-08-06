package com.example.tennn_000.trenn;


import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, View.OnTouchListener {

    View button_1; /*left jaab*/
    View button_2; /*right straight*/
    View button_3; /*left hook*/
    View button_4; /*right hook*/
    View button_5; /*left uppercut*/
    View button_6; /*right uppercut*/
    View button_7; /*left hook to the body*/
    View button_8; /*right hook to the body*/
    View button_9; /*straight right to the body*/
    View button_17; /*staight left to the body*/
    View button_10; /*left lowkick*/
    View button_11; /*right lowkick*/
    View button_12; /*left middlekick*/
    View button_13; /*right middlekick*/
    View button_14; /*left highkick*/
    View button_15; /*right highkick*/
    View button_18; /*left knee*/
    View button_19; /*right knee*/
    View button_16; /*combo*/
    TextView textview_1;
    private ImageView create_combos_background;
    //public static String MenuActivity.combo = "";
    String savedcombos = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_10 = findViewById(R.id.button_10);
        button_11 = findViewById(R.id.button_11);
        button_12 = findViewById(R.id.button_12);
        button_13 = findViewById(R.id.button_13);
        button_14 = findViewById(R.id.button_14);
        button_15 = findViewById(R.id.button_15);
        button_16 = findViewById(R.id.button_16);
        button_17 = findViewById(R.id.button_17);
        button_18 = findViewById(R.id.button_18);
        button_19 = findViewById(R.id.button_19);

        textview_1 = (TextView) findViewById(R.id.textview_1);

        create_combos_background = (ImageView) findViewById(R.id.create_combos_background);
        create_combos_background.setImageDrawable(getResources().getDrawable(R.drawable.carbon_background));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        // onclick listeneri asemel ontouch listener
        //button_1.setOnClickListener(this);
        button_1.setOnTouchListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_10.setOnClickListener(this);
        button_11.setOnClickListener(this);
        button_12.setOnClickListener(this);
        button_13.setOnClickListener(this);
        button_14.setOnClickListener(this);
        button_15.setOnClickListener(this);
        button_16.setOnClickListener(this);
        button_17.setOnClickListener(this);
        button_18.setOnClickListener(this);
        button_19.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //button_1.setOnClickListener(null);
        button_1.setOnTouchListener(null);
        button_2.setOnClickListener(null);
        button_3.setOnClickListener(null);
        button_4.setOnClickListener(null);
        button_5.setOnClickListener(null);
        button_6.setOnClickListener(null);
        button_7.setOnClickListener(null);
        button_8.setOnClickListener(null);
        button_9.setOnClickListener(null);
        button_10.setOnClickListener(null);
        button_11.setOnClickListener(null);
        button_12.setOnClickListener(null);
        button_13.setOnClickListener(null);
        button_14.setOnClickListener(null);
        button_15.setOnClickListener(null);
        button_16.setOnClickListener(null);
        button_17.setOnClickListener(null);
        button_18.setOnClickListener(null);
        button_19.setOnClickListener(null);


    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_1){
            System.out.println("button 1 clicked");
            MenuActivity.combo = MenuActivity.combo + "left jab,  ";
        }
        else if(v.getId() == R.id.button_2){
            System.out.println("button 2 clicked");
            MenuActivity.combo = MenuActivity.combo + "right straight,  ";

        }

        else if(v.getId() == R.id.button_3){
            System.out.println("button 3 clicked");
            MenuActivity.combo = MenuActivity.combo + "left hook,  ";

        }
        else if(v.getId() == R.id.button_4){
            System.out.println("button 4 clicked");
            MenuActivity.combo = MenuActivity.combo + "right hook,  ";

        }
        else if(v.getId() == R.id.button_5){
            System.out.println("button 5 clicked");
            MenuActivity.combo = MenuActivity.combo + "left uppercut,  ";

        }
        else if(v.getId() == R.id.button_6){
            System.out.println("button 6 clicked");
            MenuActivity.combo = MenuActivity.combo + "right uppercut,  ";

        }
        else if(v.getId() == R.id.button_7){
            System.out.println("button 7 clicked");
            MenuActivity.combo = MenuActivity.combo + "left hook to the body,  ";

        }
        else if(v.getId() == R.id.button_8){
            System.out.println("button 8 clicked");
            MenuActivity.combo = MenuActivity.combo + "right hook to the body,  ";

        }
        else if(v.getId() == R.id.button_9){
            System.out.println("button 9 clicked");
            MenuActivity.combo = MenuActivity.combo + "right straight to the body,  ";

        }
        else if(v.getId() == R.id.button_10){
            System.out.println("button 10 clicked");
            MenuActivity.combo = MenuActivity.combo + "left lowkick,  ";

        }
        else if(v.getId() == R.id.button_11){
            System.out.println("button 11 clicked");
            MenuActivity.combo = MenuActivity.combo + "right lowkick,  ";

        }
        else if(v.getId() == R.id.button_12){
            System.out.println("button 12 clicked");
            MenuActivity.combo = MenuActivity.combo + "left middlekick,  ";

        }
        else if(v.getId() == R.id.button_13){
            System.out.println("button 13 clicked");
            MenuActivity.combo = MenuActivity.combo + "right middlekick,  ";

        }
        else if(v.getId() == R.id.button_14){
            System.out.println("button 14 clicked");
            MenuActivity.combo = MenuActivity.combo + "left highkick,  ";

        }
        else if(v.getId() == R.id.button_15){
            System.out.println("button 15 clicked");
            MenuActivity.combo = MenuActivity.combo + "right highkick,  ";

        }
        else if(v.getId() == R.id.button_17){
            System.out.println("button 17 clicked");
            MenuActivity.combo = MenuActivity.combo + "left straight to the body,  ";

        }
        else if(v.getId() == R.id.button_18){
            System.out.println("button 18 clicked");
            MenuActivity.combo = MenuActivity.combo + "left knee,  ";

        }
        else if(v.getId() == R.id.button_19){
            System.out.println("button 19 clicked");
            MenuActivity.combo = MenuActivity.combo + "right knee,  ";

        }
        else if(v.getId() == R.id.button_16){
            System.out.println("button 16 clicked");
            textview_1.setText(MenuActivity.combo);
            if(MenuActivity.combo != ""){
                MenuActivity.savedComboCounter = MenuActivity.savedComboCounter + 1;
                MenuActivity.savedCombo = MenuActivity.savedCombo + "Combo nr "
                        + MenuActivity.savedComboCounter + ": \n"
                        + MenuActivity.combo.substring(0, MenuActivity.combo.length()-3) + "\n\n";
                MenuActivity.combo = "";

                MenuActivity.editor.putString("combos", MenuActivity.savedCombo);

                MenuActivity.editor.commit();
            }
        }
    }

    private Rect rect;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // tee kõigi nuppudega samasugused if laused
        if (v.getId() == R.id.button_1) {
            // seda ma prindin logimiseks - pole vaja teha
            System.out.println("button 1 ontouched");
            if (event.getAction() == MotionEvent.ACTION_UP) {
                // kui näpp võetakse ära, siis pole pilt läbipaistev
                setAlphaForView(v, 1.0f);
                if (rect != null && !rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                    return true;
                }
                // siia kirjuta see, mis juhtub kui näpp võetakse nupu pealt ära
                MenuActivity.combo = MenuActivity.combo + "left jab,  ";
                return true;

            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                // kui näpp pannakse nupu peale, siis tehakse pilt poolenisti läbipaistvaks
                setAlphaForView(v, 0.5f);
                return true;
            }
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