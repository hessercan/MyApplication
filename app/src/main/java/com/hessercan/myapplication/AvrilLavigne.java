package com.hessercan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AvrilLavigne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avril_lavigne);

        EditText avrilCommentText = findViewById(R.id.avril_editText);
        avrilCommentText.setText(getIntent().getStringExtra("Avril Comment"));
    }

    private String getAvrilComment() {
        EditText avrilCommentText = findViewById(R.id.avril_editText);
        return avrilCommentText.getText().toString();
    }

    public void goHome(View view) {
        Intent goHomeIntent = new Intent(this,MainActivity.class);
        goHomeIntent.putExtra("Avril Comment", getAvrilComment());
        goHomeIntent.putExtra("Jovi Comment", getIntent().getStringExtra("Jovi Comment"));
        startActivity(goHomeIntent);
    }
}
