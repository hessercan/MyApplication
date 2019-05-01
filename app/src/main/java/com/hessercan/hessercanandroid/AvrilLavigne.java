package com.hessercan.hessercanandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

public class AvrilLavigne extends AppCompatActivity {

    private RatingBar avrilRatingBar;
    SharedPreferences prefs;
    private String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avril_lavigne);
        username = getIntent().getStringExtra("username");
        prefs = getSharedPreferences(username + "_PREFS", MODE_PRIVATE);
        avrilRatingBar = findViewById(R.id.avril_ratingBar);
        avrilRatingBar.setRating(prefs.getFloat("Avril Rating", 0));

    }

    private void saveRating(){
        prefs.edit().putFloat("Avril Rating", avrilRatingBar.getRating()).commit();
    }

    public void goHome(View view) {
        Intent goHomeIntent = new Intent(this, MainActivity.class);
        saveRating();
        startActivity(goHomeIntent);
        finish();
    }
}
