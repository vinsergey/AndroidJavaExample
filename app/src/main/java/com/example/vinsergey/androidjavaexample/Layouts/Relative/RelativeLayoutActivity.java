package com.example.vinsergey.androidjavaexample.Layouts.Relative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class RelativeLayoutActivity extends AppCompatActivity {

    public static final String RELATIVE_LAYOUT_TITLE = "relative";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(RELATIVE_LAYOUT_TITLE);
        setTitle(value);

        final ImageView imageOne = findViewById(R.id.img_android_icon);
        final ImageView imageTwo = findViewById(R.id.img_android_icon_up);

        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageOne.getVisibility() == View.VISIBLE) {
                    imageOne.setVisibility(View.GONE);
                    imageTwo.setVisibility(View.VISIBLE);
                }
            }
        });

        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageTwo.getVisibility() == View.VISIBLE) {
                    imageTwo.setVisibility(View.GONE);
                    imageOne.setVisibility(View.VISIBLE);
                }
            }
        });

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


}
