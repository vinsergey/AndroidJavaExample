package com.example.vinsergey.androidjavaexample.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class TextViewActivity extends AppCompatActivity {

    private static final String TEXT_VIEW_LAYOUT_TITLE = "text_view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(TEXT_VIEW_LAYOUT_TITLE);
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
