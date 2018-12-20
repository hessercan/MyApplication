package com.hessercan.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Comment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (!checkVersion()) {
            setContentView(R.layout.activity_old_version);
        } else {
            setContentView(R.layout.activity_main);
            setOrientationMessage();

            TextView versionMessage = findViewById(R.id.versionCheckMessage);
            versionMessage.setText(checkVersionMessage());

            TextView avrilComment = findViewById(R.id.avril_comment);
            avrilComment.setText(getIntent().getStringExtra("Avril Comment"));

            TextView joviComment = findViewById(R.id.bonjovi_comment);
            joviComment.setText(getIntent().getStringExtra("Jovi Comment"));
        }
    }

    private void setOrientationMessage() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkVersion() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }

    private String checkVersionMessage() {
        if (checkVersion()) return "Thank You for keeping your phone up to date.";
        else return "Android Version too old. Please update to 7.0 or later.";
    }

    public void startBonJoviView(View view) {
        Intent bonjoviIntent = new Intent(this,BonJovi.class);
        bonjoviIntent.putExtra("Avril Comment", getAvrilComment());
        bonjoviIntent.putExtra("Jovi Comment", getJoviComment());
        startActivity(bonjoviIntent);
    }
    public void startAvrilView(View view) {
        Intent avrilIntent = new Intent(this,AvrilLavigne.class);
        avrilIntent.putExtra("Avril Comment", getAvrilComment());
        avrilIntent.putExtra("Jovi Comment", getJoviComment());
        startActivity(avrilIntent);
    }

    private String getJoviComment(){
        TextView joviComment = findViewById(R.id.bonjovi_comment);
        return joviComment.getText().toString();
    }
    private String getAvrilComment(){
        TextView avrilComment = findViewById(R.id.avril_comment);
        return avrilComment.getText().toString();
    }
}

