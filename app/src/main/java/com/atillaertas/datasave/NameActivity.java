package com.atillaertas.datasave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;



public class NameActivity extends AppCompatActivity {
    EditText nameText;
    EditText surnameText;

    TextView textView;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    String storedName;

    String storedSurName;

    Integer age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameText = (EditText)findViewById(R.id.nameInput);
        surnameText = (EditText) findViewById(R.id.surnameInput);
        textView = (TextView) findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.atillaertas.datasave", Context.MODE_PRIVATE);

        age = getIntent().getIntExtra("storedAge",0);

        storedName = sharedPreferences.getString("name","");
        storedSurName = sharedPreferences.getString("surname", "");

        if (storedName == "" && storedSurName == ""){
            textView.setText("Name: \nSurname: ");
        }
        else{
            textView.setText("Name: " + storedName + "\n" + "Surname: " + storedSurName + "\n" +"Age: " + age);
        }
        editor = sharedPreferences.edit();
    }



    public void ageActivity(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void saveName(View view){
        if (!nameText.getText().toString().matches("")){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Save");
            alert.setMessage("Kaydedilsin mi?");
            alert.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String name = nameText.getText().toString();
                    String surName = surnameText.getText().toString();

                    textView.setText("Name: " + name + "\n" + "Surname: " + surName + "\n" +"Age: " + age);

                    editor.putString("name",name);
                    editor.putString("surname",surName);
                    editor.apply();

                    Toast.makeText(NameActivity.this, "Kaydedildi", Toast.LENGTH_SHORT).show();

                }
            });
            alert.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(NameActivity.this, "İptal Edildi", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }
    }



    public void clearName(View view){
        if (!surnameText.getText().toString().matches("")){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Clear");
            alert.setMessage("Temizlensin mi?");
            alert.setPositiveButton("Temizle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sharedPreferences.edit().remove("name").apply();
                    sharedPreferences.edit().remove("surname").apply();
                    textView.setText("Name: \nSurname: ");
                    Toast.makeText(NameActivity.this, "Temizlendi", Toast.LENGTH_SHORT).show();
                }
            });
            alert.setNegativeButton("Kaydetme", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(NameActivity.this, "İptal Edildi", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }
    }
}