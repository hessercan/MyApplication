package com.hessercan.hessercanandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SceneTransCustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_trans_custom);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
