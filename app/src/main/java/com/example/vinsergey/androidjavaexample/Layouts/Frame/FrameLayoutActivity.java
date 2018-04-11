package com.example.vinsergey.androidjavaexample.Layouts.Frame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;

public class FrameLayoutActivity extends AppCompatActivity {

    public static final String FRAME_LAYOUT_TITLE = "frame";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(FRAME_LAYOUT_TITLE);
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
