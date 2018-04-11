package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityConstraintLayoutBinding;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;
import static com.example.vinsergey.androidjavaexample.Layouts.Constraint.Constants.*;

public class ConstraintLayoutActivity extends AppCompatActivity {

    private static final String CONSTRAINT_LAYOUT_ACTIVITY_TITLE = "constraint";
    private static final String KEY_LOGIN = "login_user";
    private static final String KEY_REGISTRATION = "registration_user";

    private Intent mIntent;
    private Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);

        ActivityConstraintLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_constraint_layout);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ConstraintLayoutActivity.this, LoginActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LOGIN, getResources().getString(R.string.text_login));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        binding.btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ConstraintLayoutActivity.this, RegistrationActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_REGISTRATION, getResources().getString(R.string.text_registration));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String value = Objects.requireNonNull(getIntent().getExtras()).getString(CONSTRAINT_LAYOUT_ACTIVITY_TITLE);
        setTitle(value);

        if (loadUserStatus()) {
            mIntent = new Intent(ConstraintLayoutActivity.this, UserProfileActivity.class);
            startActivity(mIntent);
        }
    }

    private boolean loadUserStatus() {
        SharedPreferences sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        return sPref.getBoolean(REGISTRATION_USER_STATUS, false) &&
                sPref.getBoolean(AUTHORIZATION_USER_STATUS, false);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
