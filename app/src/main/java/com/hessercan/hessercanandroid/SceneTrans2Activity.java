package com.hessercan.hessercanandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;

public class SceneTrans2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_trans2);

        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());
    }
}
