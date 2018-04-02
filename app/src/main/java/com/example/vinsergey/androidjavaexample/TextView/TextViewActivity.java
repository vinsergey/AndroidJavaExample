package com.example.vinsergey.androidjavaexample.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class TextViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString("text_view");
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
