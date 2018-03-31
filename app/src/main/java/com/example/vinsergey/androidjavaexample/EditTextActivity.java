package com.example.vinsergey.androidjavaexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        Intent intent = getIntent();

        if (intent != null) {
            String value = intent.getExtras().getString("edit_text");
            setTitle(value);
        }
    }
}
