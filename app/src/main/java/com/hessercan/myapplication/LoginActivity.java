package com.hessercan.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        currentUser = getSharedPreferences("currentUser", MODE_PRIVATE);

    }

    public void startLoginProcess(View view) {
        Intent startMainIntent = new Intent(this, MainActivity.class);
        setCurrentUser(getLoginInfo());
        startActivity(startMainIntent);
        finish();
    }

    private String getLoginInfo() {
        TextView loginInfo = findViewById(R.id.username_editText);
        return loginInfo.getText().toString();
    }

    private void setCurrentUser(String username) {
        currentUser.edit().putString("username", username.toLowerCase()).commit();
    }
}
