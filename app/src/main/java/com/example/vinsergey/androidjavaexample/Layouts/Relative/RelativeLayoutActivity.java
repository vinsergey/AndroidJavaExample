package com.example.vinsergey.androidjavaexample.Layouts.Relative;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityRelativeLayoutBinding;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;

public class RelativeLayoutActivity extends AppCompatActivity {

    public static final String RELATIVE_LAYOUT_TITLE = "relative";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);

        final ActivityRelativeLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_relative_layout);


        binding.imgAndroidIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.imgAndroidIcon.getVisibility() == View.VISIBLE) {
                    binding.imgAndroidIcon.setVisibility(View.GONE);
                    binding.imgAndroidIconUp.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.imgAndroidIconUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.imgAndroidIconUp.getVisibility() == View.VISIBLE) {
                    binding.imgAndroidIconUp.setVisibility(View.GONE);
                    binding.imgAndroidIcon.setVisibility(View.VISIBLE);
                }
            }
        });

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(RELATIVE_LAYOUT_TITLE);
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


}
