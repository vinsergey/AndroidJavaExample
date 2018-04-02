package com.example.vinsergey.androidjavaexample.Layouts.Linear;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class LinearLayoutsActivity extends AppCompatActivity {

    private static final String KEY_LINEAR_LAYOUT_HORIZONTAL = "horizontal";
    private static final String KEY_LINEAR_LAYOUT_VERTICAL = "vertical";
    private static final String KEY_LINEAR_LAYOUT_WITH_WEIGHT = "with_weight";
    private Intent mIntent;
    private Bundle mBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layouts);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString("linear");
        setTitle(value);

        Button btnLinearLayoutHorizontal = findViewById(R. id.btn_linear_horizontal_layout);
        Button btnLinearLayoutVertical = findViewById(R. id.btn_linear_vertical_layout);
        Button btnLinearLayoutWithWeight = findViewById(R. id.btn_linear_layout_with_weight);

        btnLinearLayoutHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LinearLayoutsActivity.this, LinearLayoutHorizontalActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LINEAR_LAYOUT_HORIZONTAL, getResources().getString(R.string.btn_linear_horizontal_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnLinearLayoutVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LinearLayoutsActivity.this, LinearLayoutVerticalActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LINEAR_LAYOUT_VERTICAL, getResources().getString(R.string.btn_linear_vertical_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnLinearLayoutWithWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LinearLayoutsActivity.this, LinearLayoutWithWeightActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LINEAR_LAYOUT_WITH_WEIGHT, getResources().getString(R.string.btn_linear_layout_with_weight));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
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
