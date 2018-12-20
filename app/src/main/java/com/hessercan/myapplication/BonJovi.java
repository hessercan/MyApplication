package com.hessercan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BonJovi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_jovi);

        EditText joviCommentText = findViewById(R.id.jovi_editText);
        joviCommentText.setText(getIntent().getStringExtra("Jovi Comment"));
    }

    private String getJoviComment() {
        EditText joviCommentText = findViewById(R.id.jovi_editText);
        return joviCommentText.getText().toString();
    }

    public void goHome(View view) {
        Intent goHomeIntent = new Intent(this, MainActivity.class);
        goHomeIntent.putExtra("Jovi Comment", getJoviComment());
        goHomeIntent.putExtra("Avril Comment", getIntent().getStringExtra("Avril Comment"));
        startActivity(goHomeIntent);
    }

}
