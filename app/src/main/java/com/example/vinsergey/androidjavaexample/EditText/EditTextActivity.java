package com.example.vinsergey.androidjavaexample.EditText;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.vinsergey.androidjavaexample.R;

import java.util.ArrayList;
import java.util.Objects;

public class EditTextActivity extends AppCompatActivity {

    public static final String EDIT_TEXT_LAYOUT_TITLE = "edit_text";
    AutoCompleteTextView actv;
    String[] autos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        autos = getResources().getStringArray(R.array.auto);
        actv = findViewById(R.id.complete);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, autos);
        actv.setThreshold(0);
        actv.setAdapter(adapter);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(EDIT_TEXT_LAYOUT_TITLE);
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
