package com.atillaertas.datasave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    SharedPreferences sharedPreferences;

    int storedAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.ageInput);
        textView = findViewById(R.id.ageResult);

        sharedPreferences = this.getSharedPreferences("com.atillaertas.datasave",Context.MODE_PRIVATE);

        storedAge = sharedPreferences.getInt("storedAge",0);

        if (storedAge == 0) {
            textView.setText("Your age : ");
        }else
        {
            textView.setText("Your age : " + storedAge);
        }
    }

    public void save(View view){

        if (!editText.getText().toString().matches("")){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Save");
            alert.setMessage("Kaydedilsin mi?");
            alert.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //save
                    Toast.makeText(MainActivity.this, "Kaydedildi", Toast.LENGTH_LONG).show();
                    int userAge = Integer.parseInt(editText.getText().toString());
                    textView.setText("Your age " + userAge);

                    sharedPreferences.edit().putInt("storedAge", userAge).apply();
                }
            });
            alert.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //cancel
                    Toast.makeText(MainActivity.this, "İptal Edildi", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }


    }

    public void clear(View view){
        if (storedAge != 0) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Clear");
            alert.setMessage("Temizlensin mi?");
            alert.setPositiveButton("Temizle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //temizleme
                    sharedPreferences.edit().remove("storedAge").apply();
                    textView.setText("Your age : ");
                    Toast.makeText(MainActivity.this, "Temizlendi", Toast.LENGTH_SHORT).show();
                }
            });
            alert.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //cancel
                    Toast.makeText(MainActivity.this, "İptal Edildi", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }
    }

}