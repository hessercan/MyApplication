package com.hessercan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFilesActivity extends AppCompatActivity {

    private File mImagesDir;
    File[] mImageFiles;
    String[] mImageFilenames;
    Intent mResultIntent;

    private static final String AUTHORITY = BuildConfig.APPLICATION_ID+".fileprovider";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_files);

        mResultIntent = new Intent("com.hessercan.myapplication.ACTION_RETURN_FILE");

        mImagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        mImageFiles = mImagesDir.listFiles();

        setResult(Activity.RESULT_CANCELED, null);

        int i = 0;
        mImageFilenames = new String[mImageFiles.length];
        try {
            for (File f : mImageFiles) {
                mImageFilenames[i] = f.getAbsolutePath();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ListView mFileListView = findViewById(R.id.mFileListView);

        final List<String> fileList = new ArrayList<>(Arrays.asList(mImageFilenames));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fileList);

        mFileListView.setAdapter(arrayAdapter);

        mFileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File requestFile = new File(mImageFilenames[position]);

                Uri fileUri = null;
                try {
                    fileUri = FileProvider.getUriForFile(ListFilesActivity.this, AUTHORITY, requestFile);
                } catch (Exception e) {
                    Log.e("File Selector", "The selected file can't be shared: " + requestFile.toString());
                }

                if (fileUri != null) {
                    mResultIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                    mResultIntent.setDataAndType(fileUri, getContentResolver().getType(fileUri));

                    ListFilesActivity.this.setResult(Activity.RESULT_OK, mResultIntent);

                } else {
                    mResultIntent.setDataAndType(null, "");
                    ListFilesActivity.this.setResult(RESULT_CANCELED, mResultIntent);
                }
                finish();
            }
        });
    }

    public void onDoneClick(View view) {
        finish();
    }


}
