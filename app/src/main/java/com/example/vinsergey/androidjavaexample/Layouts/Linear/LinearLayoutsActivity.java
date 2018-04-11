package com.example.vinsergey.androidjavaexample.Layouts.Linear;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityLinearLayoutsBinding;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;

public class LinearLayoutsActivity extends AppCompatActivity {

    private static final String KEY_LINEAR_LAYOUT_HORIZONTAL = "horizontal";
    private static final String KEY_LINEAR_LAYOUT_VERTICAL = "vertical";
    private static final String KEY_LINEAR_LAYOUT_WITH_WEIGHT = "with_weight";
    private static final String LINEAR_LAYOUT_TITLE = "linear";
    private Intent mIntent;
    private Bundle mBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);

        ActivityLinearLayoutsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_linear_layouts);

        binding.btnLinearHorizontalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LinearLayoutsActivity.this, LinearLayoutHorizontalActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LINEAR_LAYOUT_HORIZONTAL, getResources().getString(R.string.btn_linear_horizontal_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        binding.btnLinearVerticalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LinearLayoutsActivity.this, LinearLayoutVerticalActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LINEAR_LAYOUT_VERTICAL, getResources().getString(R.string.btn_linear_vertical_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        binding.btnLinearLayoutWithWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LinearLayoutsActivity.this, LinearLayoutWithWeightActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LINEAR_LAYOUT_WITH_WEIGHT, getResources().getString(R.string.btn_linear_layout_with_weight));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(LINEAR_LAYOUT_TITLE);
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
