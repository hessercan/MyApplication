package com.hessercan.hessercanandroid;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class ScenesActivity extends AppCompatActivity {

    Scene aScene;
    Scene bScene;
    Scene cScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);

        ViewGroup root_scene = findViewById(R.id.root);
        aScene = Scene.getSceneForLayout(root_scene, R.layout.scene_a, this);
        bScene = Scene.getSceneForLayout(root_scene, R.layout.scene_b, this);
        cScene = Scene.getSceneForLayout(root_scene, R.layout.scene_c, this);


    }

    public void startTrans1(View v) {
        Intent trans1Intent = new Intent(this, SceneTrans1Activity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(trans1Intent, options.toBundle());
    }
    public void startTrans2(View v) {
        Intent trans2Intent = new Intent(this, SceneTrans2Activity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(trans2Intent, options.toBundle());
    }
    public void startCustomTrans(View v) {
        Intent transCustomIntent = new Intent(this, SceneTransCustomActivity.class);
        startActivity(transCustomIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void aSceneTrans(View v) {
        TransitionManager.go(aScene, new Fade());
    }
    public void bSceneTrans(View v) {
        TransitionManager.go(bScene, new Slide());
    }
    public void cSceneTrans(View v) {
        TransitionManager.go(cScene, new Explode());
    }
}
