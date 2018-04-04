package com.example.vinsergey.androidjavaexample.Layouts.Grid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vinsergey.androidjavaexample.R;

import java.util.Objects;

public class GridLayoutActivity extends AppCompatActivity {

    public static final String GRIA_LAYOUT_TITLE = "grid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(GRIA_LAYOUT_TITLE);
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
