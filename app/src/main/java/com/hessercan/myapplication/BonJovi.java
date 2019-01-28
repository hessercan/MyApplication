package com.hessercan.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

public class BonJovi extends AppCompatActivity {

    private RatingBar joviRatingBar;
    SharedPreferences prefs;
    private String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_jovi);
        username = getIntent().getStringExtra("username");
        prefs = getSharedPreferences(username + "_PREFS", MODE_PRIVATE);
        joviRatingBar = findViewById(R.id.jovi_ratingBar);
        joviRatingBar.setRating(prefs.getFloat("BonJovi Rating", 0));

    }

    private void saveRating(){
        prefs.edit().putFloat("BonJovi Rating", joviRatingBar.getRating()).commit();
    }

    public void goHome(View view) {
        Intent goHomeIntent = new Intent(this, MainActivity.class);
        saveRating();
        startActivity(goHomeIntent);
        finish();
    }
}

