package com.example.vinsergey.androidjavaexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_LAYOUT = "layout";
    public static final String KEY_BUTTON = "button";
    public static final String KEY_TEXT_VIEW = "text_view";
    public static final String KEY_EDIT_TEXT = "edit_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLayouts = findViewById(R.id.btn_layouts);
        Button btnButton = findViewById(R.id.btn_button);
        Button btnTextView = findViewById(R.id.btn_text_view);
        Button btnEditText = findViewById(R.id.btn_edit_text);

        btnLayouts.setOnClickListener(e -> {
            Intent mIntent = new Intent(this, LayoutsActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putString(KEY_LAYOUT, getResources().getString(R.string.btn_layout));
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        });

        btnButton.setOnClickListener(e -> {
            Intent mIntent = new Intent(this, ButtonActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putString(KEY_BUTTON, getResources().getString(R.string.btn_button));
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        });

        btnTextView.setOnClickListener(e -> {
            Intent mIntent = new Intent(this, TextViewActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putString(KEY_TEXT_VIEW, getResources().getString(R.string.btn_text_view));
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        });

        btnEditText.setOnClickListener(e -> {
            Intent mIntent = new Intent(this, EditTextActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putString(KEY_EDIT_TEXT, getResources().getString(R.string.btn_edit_text));
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        });
    }
}
