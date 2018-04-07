package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.vinsergey.androidjavaexample.R;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String value = Objects.requireNonNull(getIntent().getExtras()).getString(CONSTRAINT_LAYOUT_ACTIVITY_TITLE);
        setTitle(value);

        Button login = findViewById(R.id.btn_login);
        Button registration = findViewById(R.id.btn_registration);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ConstraintLayoutActivity.this, LoginActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_LOGIN, getResources().getString(R.string.text_login));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ConstraintLayoutActivity.this, RegistrationActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_REGISTRATION, getResources().getString(R.string.text_registration));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

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
