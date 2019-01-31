package com.hessercan.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    SharedPreferences currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setActivityBackgroundColor(Color.LTGRAY);

        if (!checkVersion()) {
            setContentView(R.layout.activity_old_version);
        } else {

            currentUser = getSharedPreferences("currentUser", MODE_PRIVATE);
            prefs = getSharedPreferences(getUsername() + "_PREFS", MODE_PRIVATE);

            if (currentUser.contains("username")) {

                setContentView(R.layout.activity_main);
                setOrientationMessage();

                TextView versionMessage = findViewById(R.id.versionCheckMessage);
                versionMessage.setText(checkVersionMessage());

                loadData();
            }
            else {
                startLoginActivity();
            }
        }
    }

    public String getUsername() {
        return currentUser.getString("username", "none").toLowerCase();
    }

    private void setRatings() {
        RatingBar avrilRatingBar = findViewById(R.id.avrilRating);
        avrilRatingBar.setRating(prefs.getFloat("Avril Rating", 0));
        RatingBar bonjoviRating = findViewById(R.id.joviRating);
        bonjoviRating.setRating(prefs.getFloat("BonJovi Rating", 0));
    }

    public void startLoginActivity(View view){
        currentUser.edit().remove("username").commit();
        Intent startLoginIntent = new Intent(this, LoginActivity.class);
        startLoginIntent.putExtra("username", getUsername());
        startActivity(startLoginIntent);
        finish();
    }
    public void startLoginActivity(){
        currentUser.edit().remove("username").commit();
        Intent startLoginIntent = new Intent(this, LoginActivity.class);
        startLoginIntent.putExtra("username", getUsername());
        startActivity(startLoginIntent);
        finish();
    }

    public void startAvrilActivity(View view){
        Intent startAvrilIntent = new Intent(this, AvrilLavigne.class);
        startAvrilIntent.putExtra("username", getUsername());
        startActivity(startAvrilIntent);
        finish();
    }
    public void startBonJoviActivity(View view){
        Intent startJoviIntent = new Intent(this, BonJovi.class);
        startJoviIntent.putExtra("username", getUsername());
        startActivity(startJoviIntent);
        finish();
    }

    public void startPartTwo(View view) {
        Intent partTwoIntent = new Intent(this, Part2Activity.class);
        startActivity(partTwoIntent);
    }

    public void loadData() {
        TextView welcomeUser = findViewById(R.id.welcomeUser_TextView);
        welcomeUser.setText("Welcome: " + getUsername());

        setRatings();
    }

    private void setOrientationMessage() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            toastMessage("Landscape");
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            toastMessage("Portrait");
        }
    }

    private boolean checkVersion() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }

    private String checkVersionMessage() {
        if (checkVersion()) return "Thank You for keeping your phone up to date.";
        else return "Android Version too old. Please update to 7.0 or later.";
    }

    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}

