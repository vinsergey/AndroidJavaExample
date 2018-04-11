package com.example.vinsergey.androidjavaexample.Layouts.Table;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;

public class TableLayoutActivity extends AppCompatActivity {

    public static final String TABLE_LAYOUT_TITLE = "table";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(TABLE_LAYOUT_TITLE);
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
