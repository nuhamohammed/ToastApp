package com.mohammednuha.quizapp.toastapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{
public  TextView t1,t2,t3,t4;
public  int[] counter   = new int [4];
   public SharedPreferences sp;
    public SharedPreferences.Editor editor;
    public SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sp = getSharedPreferences("TOAST_APP", Context.MODE_PRIVATE);//PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sp.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(50);
        seekBar.setOnSeekBarChangeListener(this);

        t1 = findViewById(R.id.topLeft);
        t2 = findViewById(R.id.topRight);
        t3 = findViewById(R.id.bottomLeft);
        t4 = findViewById(R.id.bottomRight);

        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
    }

    public void onClick(View view) {
        String text="";
        String v=", count: ";
        int count;
        switch(view.getId()){
            case R.id.topLeft:
                text="topLeft";
                break;
            case R.id.topRight:
                text="topRight";
                break;
            case R.id.bottomLeft:
                text="bottomLeft";
                break;
            case R.id.bottomRight:
                text="bottomRight";
                break;
        }
        count= sp.getInt(text, 0)+1;
        editor.putInt(text,count);
        editor.apply();
        v+=count+"";
        Log.i("onclick", text+v);
        Toast toast = Toast.makeText(getApplicationContext(), text+v, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void onStartTrackingTouch (SeekBar seekBar){

    }
    public void onStopTrackingTouch (SeekBar seekBar){

    }
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
        t1.setTextSize(progress+14);
    }
}
