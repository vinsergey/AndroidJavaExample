package com.example.vinsergey.androidjavaexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class LayoutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        Intent intent = getIntent();

        if (intent != null) {
            String value = intent.getExtras().getString("layout");
            setTitle(value);
        }
    }
}
