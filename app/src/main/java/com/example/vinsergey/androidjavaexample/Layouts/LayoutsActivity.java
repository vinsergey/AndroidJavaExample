package com.example.vinsergey.androidjavaexample.Layouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.vinsergey.androidjavaexample.R;

import java.util.Objects;

public class LayoutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString("layout");
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
