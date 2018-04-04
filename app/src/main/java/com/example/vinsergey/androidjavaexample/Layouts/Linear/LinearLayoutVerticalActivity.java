package com.example.vinsergey.androidjavaexample.Layouts.Linear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class LinearLayoutVerticalActivity extends AppCompatActivity {

    public static final String LINEAR_VERTICAL_LAYOUT_TITLE = "vertical";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_vertical);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(LINEAR_VERTICAL_LAYOUT_TITLE);
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
