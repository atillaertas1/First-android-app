package com.atillaertas.datasave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        textView = findViewById(R.id.textView2);

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                textView.setText("" + (l/1000));
                if (l/ 1000 == 3) {
                    showToast("3 saniye sonra ana sayfaya aktarılacaksınız!");
                }
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                showToast("Ana sayfaya aktarıldınız!");
            }
        }.start();
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}