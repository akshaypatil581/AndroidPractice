package com.example.eggtimerapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int time;
    SeekBar seekBar;
    Button button;
    boolean go = true;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        countDownTimer.cancel();
        seekBar.setEnabled(true);
        button.setText("GO");
        go = true;
        time = 30;
        seekBar.setProgress(time);
    }

    public void setTimer(int timer){
        String minutes = Integer.toString(timer / 60);
        String seconds = Integer.toString(timer % 60);
        textView.setText(minutes + ":" + seconds);
    }

    public void runTimer(View view){
        if(go == true){
            go = false;
            seekBar.setEnabled(false);
            button.setText("STOP!");
            countDownTimer = new CountDownTimer(1000 * seekBar.getProgress(), 1000){
                public void onTick(long millisecondsUntilDone) { //Telling us how much time until finish
                    setTimer(time);
                    time--;
                    //Log.i("Seconds left!", String.valueOf(millisecondsUntilDone / 1000));
                }
                public void onFinish() {
                    setTimer(time);
                    time--;
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mediaPlayer.start(); // no need to call prepare(); create() does that for you
                    resetTimer();
                }
            }.start();
        } else {
            resetTimer();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView2);

        int max = 3600;
        time = 30;

        seekBar.setMax(max);
        seekBar.setProgress(time);

        setTimer(time);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setTimer(progress);
                time = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
