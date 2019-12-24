package com.example.timestables2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView tTListView;

    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for(int i = 1; i <= 10; i++){
            timesTableContent.add(Integer.toString(i * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        tTListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tTSeekBar = findViewById(R.id.tTseekBar);
        tTListView = findViewById(R.id.tTListView);

        int max = 20;
        int startingPosition = 10;

        tTSeekBar.setMax(max);
        tTSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        tTSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if(progress < min){
                    timesTableNumber = min;
                    tTSeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                Log.i("info", Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);

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
