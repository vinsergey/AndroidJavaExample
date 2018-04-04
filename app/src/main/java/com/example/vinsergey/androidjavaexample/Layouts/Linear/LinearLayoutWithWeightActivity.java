package com.example.vinsergey.androidjavaexample.Layouts.Linear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class LinearLayoutWithWeightActivity extends AppCompatActivity {

    public static final String LINEAR_WHIT_WEIGHT_LAYOUT_TITLE = "with_weight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_with_weight);

        String value = getIntent().getExtras().getString(LINEAR_WHIT_WEIGHT_LAYOUT_TITLE);
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
