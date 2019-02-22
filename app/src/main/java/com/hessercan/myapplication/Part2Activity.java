package com.hessercan.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Part2Activity extends AppCompatActivity {

    private final String SUBJECT = "Help Me with My Application";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
    }

    public void sendEmail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","mark@hessercan.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, SUBJECT);
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public void openMaps(View view) {
        Uri uri = Uri.parse("https://www.google.com/maps/place/Beaver+Stadium/@40.8121998,-77.858291,17z/data=!3m1!4b1!4m5!3m4!1s0x89cea616f1f2a0ad:0xfd2e8b79990c4ad5!8m2!3d40.8121958!4d-77.8561023");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    public void openGoogleSearch(View view) {
        String url = "https://www.google.com";
        Intent googleIntent = new Intent(Intent.ACTION_VIEW);
        googleIntent.setData(Uri.parse(url));
        startActivity(googleIntent);
    }

    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(this, TakePicture.class);
        startActivity(takePictureIntent);

    }

    public void listFiles(View view) {
        Intent listFilesIntent = new Intent(this, ListFilesActivity.class);
        startActivity(listFilesIntent);

    }

    public void openScenes(View view) {
        Intent openScenesIntent = new Intent(this, ScenesActivity.class);
        startActivity(openScenesIntent);
    }
}
