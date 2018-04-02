package com.example.vinsergey.androidjavaexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.vinsergey.androidjavaexample.Buttons.ButtonActivity;
import com.example.vinsergey.androidjavaexample.EditText.EditTextActivity;
import com.example.vinsergey.androidjavaexample.Layouts.LayoutsActivity;
import com.example.vinsergey.androidjavaexample.TextView.TextViewActivity;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_LAYOUT = "layout";
    private static final String KEY_BUTTON = "button";
    private static final String KEY_TEXT_VIEW = "text_view";
    private static final String KEY_EDIT_TEXT = "edit_text";

    private Intent mIntent;
    private Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLayouts = findViewById(R.id.btn_layouts);
        Button btnButton = findViewById(R.id.btn_button);
        Button btnTextView = findViewById(R.id.btn_text_view);
        Button btnEditText = findViewById(R.id.btn_edit_text);

        btnLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(MainActivity.this, LayoutsActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LAYOUT, getResources().getString(R.string.btn_layout));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(MainActivity.this, ButtonActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_BUTTON, getResources().getString(R.string.btn_button));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(MainActivity.this, TextViewActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_TEXT_VIEW, getResources().getString(R.string.btn_text_view));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        btnEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(MainActivity.this, EditTextActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_EDIT_TEXT, getResources().getString(R.string.btn_edit_text));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });
    }
}
