package com.example.vinsergey.androidjavaexample.Layouts.Linear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;

public class LinearLayoutHorizontalActivity extends AppCompatActivity {

    public static final String LINEAR_HORIZONTAL_LAYOUT_TITLE = "horizontal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_horizontal);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(LINEAR_HORIZONTAL_LAYOUT_TITLE);
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
