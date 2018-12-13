package com.hessercan.myapplication;

import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOrientationMessage();

        TextView versionMessage = findViewById(R.id.versionCheckMessage);
        versionMessage.setText(checkVersionMessage());
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
}

