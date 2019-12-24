package com.example.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Count down timer it would be more preferred way to do the timer
        // Handler way was a cool way to do some things after particular amount of time

        // countdowntimer for should run for 10 sec and interval should be of 1 sec
        // It's a ready given method

        /*
        * We can slso allocate a variable to it and then put that variable to start
        * we also have to give onTick and onFinish methods as a conpulsory to this class / interface
        * */
        new CountDownTimer(10000, 100){
            public void onTick(long millisecondsUntilDone) { //Telling us how much time until finish
                Log.i("Seconds left!", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish() {
                Log.i("we are done", "no more countwown");
            }
        }.start();

        /*final Handler handler = new Handler();
        // Handler runs the runnable
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Hey hello", "A second passed by");
                // schduling the handler to run this method after x amount of time
                handler.postDelayed(this, 1000);
            }
        };
        // Giving handler to run method so that it starts the run method
        handler.post(run);*/


    }
}
