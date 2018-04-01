package com.example.vinsergey.androidjavaexample.Layouts.Ralative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vinsergey.androidjavaexample.R;

import java.util.Objects;

public class RelativeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString("relative");
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
