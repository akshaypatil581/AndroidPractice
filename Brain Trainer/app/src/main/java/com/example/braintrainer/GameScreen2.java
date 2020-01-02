package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameScreen2 extends AppCompatActivity {

    TextView timerText;
    TextView sum;
    TextView scoreText;
    TextView rightWrong;

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button playAgain;

    int total = 0;
    int score = 0;
    int numOfRounds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen2);

        timerText = findViewById(R.id.timerText);
        sum = findViewById(R.id.sumTv);

        scoreText = findViewById(R.id.scoreText);
        scoreText.setText("0 / 0");

        rightWrong = findViewById(R.id.rightWrong);
        rightWrong.setVisibility(View.GONE);


        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        playAgain = findViewById(R.id.playAgain);
        playAgain.setVisibility(View.GONE);

        gameStart();
    }

    public void gameStart(){
        timer();
        sum();

    }

    public void timer(){
        CountDownTimer countDownTimer = new CountDownTimer(30100, 1000){
            public void onTick(long millisecondsUntilDone) { //Telling us how much time until finish
                timerText.setText((millisecondsUntilDone / 1000) + "s");
                Log.i("Seconds left!", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish() {
                Log.i("we are done", "no more countwown");
                done();
            }
        };

        countDownTimer.start();
    }

    public void done(){
        rightWrong.setText("Game Over");
        playAgain.setText("Play Again");
        playAgain.setVisibility(View.VISIBLE);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
    }

    public void sum(){
        // show the sum of random numbers between 0 to 20
        Random rand = new Random();

        // Generate random integers in range 0 to 20
        int rand_int1 = rand.nextInt(20);
        int rand_int2 = rand.nextInt(20);

        sum.setText(rand_int1 + " + " + rand_int2);
        total = rand_int1 + rand_int2;
        //setValues(total);
        int random_button = rand.nextInt(4);
        Log.i("info", "value of random button" + random_button);
        String totalString = Integer.toString(total);
        Log.i("info", "value of total" + totalString);
        if(random_button == 0){
            b1.setText(totalString);
            b2.setText(Integer.toString(rand.nextInt(40)));
            b3.setText(Integer.toString(rand.nextInt(40)));
            b4.setText(Integer.toString(rand.nextInt(40)));
        } if(random_button == 1){
            b2.setText(totalString);
            b1.setText(Integer.toString(rand.nextInt(40)));
            b3.setText(Integer.toString(rand.nextInt(40)));
            b4.setText(Integer.toString(rand.nextInt(40)));
        } if(random_button == 2){
            b3.setText(totalString);
            b1.setText(Integer.toString(rand.nextInt(40)));
            b2.setText(Integer.toString(rand.nextInt(40)));
            b4.setText(Integer.toString(rand.nextInt(40)));
        } if(random_button == 3){
            b4.setText(totalString);
            b1.setText(Integer.toString(rand.nextInt(40)));
            b2.setText(Integer.toString(rand.nextInt(40)));
            b3.setText(Integer.toString(rand.nextInt(40)));
        }
    }

    public void setValues(int total){
        Random rand2 = new Random();

        int random_button = rand2.nextInt(4);

    }

    public void b1Click(View view){
        int b1Value = Integer.parseInt(b1.getText().toString());
        if(b1Value == total){
            increaseScore();
            increaseNumberOfRounds();
            rightWrong.setText("Correct");
            rightWrong.setVisibility(View.VISIBLE);
        } else {
            increaseNumberOfRounds();
            rightWrong.setText("Wrong");
            rightWrong.setVisibility(View.VISIBLE);
        }
        updateScore();

    }

    public void b2Click(View view){
        int b2Value = Integer.parseInt(b2.getText().toString());
        if(b2Value == total){
            increaseScore();
            increaseNumberOfRounds();
            rightWrong.setText("Correct");
            rightWrong.setVisibility(View.VISIBLE);
        } else {
            increaseNumberOfRounds();
            rightWrong.setText("Wrong");
            rightWrong.setVisibility(View.VISIBLE);
        }
        updateScore();
    }
    public void b3Click(View view){
        int b3Value = Integer.parseInt(b3.getText().toString());
        if(b3Value == total){
            increaseScore();
            increaseNumberOfRounds();
            rightWrong.setText("Correct");
            rightWrong.setVisibility(View.VISIBLE);
        } else {
            increaseNumberOfRounds();
            rightWrong.setText("Wrong");
            rightWrong.setVisibility(View.VISIBLE);
        }
        updateScore();
    }
    public void b4Click(View view){
        int b4Value = Integer.parseInt(b4.getText().toString());
        if(b4Value == total){
            increaseScore();
            increaseNumberOfRounds();
            rightWrong.setText("Correct");
            rightWrong.setVisibility(View.VISIBLE);
        } else {
            increaseNumberOfRounds();
            rightWrong.setText("Wrong");
            rightWrong.setVisibility(View.VISIBLE);
        }
        updateScore();
    }


    public void increaseScore(){
        score++;
    }

    public void increaseNumberOfRounds(){
        numOfRounds++;
    }

    public void updateScore(){
        scoreText.setText(score + " / " + numOfRounds);
        sum();
    }
    /*public void setTimer(int timer){
        String seconds = Integer.toString(timer % 60);
        timerText.setText(minutes + ":" + seconds);
    }*/
}
