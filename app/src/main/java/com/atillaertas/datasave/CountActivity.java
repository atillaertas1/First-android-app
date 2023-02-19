package com.atillaertas.datasave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {
    TextView mCounterTextView;
    Button mStartButton;
    Button mStopButton;
    Button mResetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        mCounterTextView = findViewById(R.id.counterTextView);
    }

    public void startButton(View view){

    }

    public void stopButton(View view){

    }

    public void resetButton(View view){

    }
}