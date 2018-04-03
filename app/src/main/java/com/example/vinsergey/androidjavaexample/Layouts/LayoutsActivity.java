package com.example.vinsergey.androidjavaexample.Layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.vinsergey.androidjavaexample.Layouts.Constraint.ConstraintLayoutActivity;
import com.example.vinsergey.androidjavaexample.Layouts.Frame.FrameLayoutActivity;
import com.example.vinsergey.androidjavaexample.Layouts.Grid.GridLayoutActivity;
import com.example.vinsergey.androidjavaexample.Layouts.Linear.LinearLayoutsActivity;
import com.example.vinsergey.androidjavaexample.Layouts.Relative.RelativeLayoutActivity;
import com.example.vinsergey.androidjavaexample.Layouts.Table.TableLayoutActivity;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class LayoutsActivity extends AppCompatActivity {

    private static final String KEY_CONSTRAINT_LAYOUT = "constraint";
    private static final String KEY_FRAME_LAYOUT = "frame";
    private static final String KEY_GRID_LAYOUT = "grid";
    private static final String KEY_LINEAR_LAYOUT = "linear";
    private static final String KEY_RELATIVE_LAYOUT = "relative";
    private static final String KEY_TABLE_LAYOUT = "table";

    private Intent mIntent;
    private Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        Button btnConstraintLayout = findViewById(R.id.btn_constraint_layout);
        Button btnFrameLayout = findViewById(R.id.btn_frame_layout);
        Button btnGridLayout = findViewById(R.id.btn_grid_layout);
        Button btnLinearLayout = findViewById(R.id.btn_linear_layout);
        Button btnRelativeLayout = findViewById(R.id.btn_relative_layout);
        Button btnTableLayout = findViewById(R.id.btn_table_layout);


        btnConstraintLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mIntent = new Intent(LayoutsActivity.this, ConstraintLayoutActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_CONSTRAINT_LAYOUT, getResources().getString(R.string.btn_constraint_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LayoutsActivity.this, FrameLayoutActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_FRAME_LAYOUT, getResources().getString(R.string.btn_frame_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LayoutsActivity.this, GridLayoutActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_GRID_LAYOUT, getResources().getString(R.string.btn_grid_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LayoutsActivity.this, LinearLayoutsActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LINEAR_LAYOUT, getResources().getString(R.string.btn_linear_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LayoutsActivity.this, RelativeLayoutActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_RELATIVE_LAYOUT, getResources().getString(R.string.btn_relative_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnTableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(LayoutsActivity.this, TableLayoutActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_TABLE_LAYOUT, getResources().getString(R.string.btn_table_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

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
