package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    boolean isGameStarted = false;

    ImageView ivGo;
    TextView tvGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivGo = findViewById(R.id.ivGo);
        tvGo = findViewById(R.id.tvGo);
    }
    //
    public void startGame(View view){
        if(isGameStarted == false){
            ivGo.setVisibility(View.GONE);
            tvGo.setVisibility(View.GONE);

            Intent intent = new Intent(this, GameScreen2.class);
            startActivity(intent);
        }
    }
}

