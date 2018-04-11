package com.example.vinsergey.androidjavaexample.Buttons;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityButtonBinding;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;

public class ButtonActivity extends AppCompatActivity {

    private static final String BUTTON_ACTIVITY_TITLE = "button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);

        ActivityButtonBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_button);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(BUTTON_ACTIVITY_TITLE);
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
