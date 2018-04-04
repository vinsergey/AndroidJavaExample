package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class ConstraintLayoutActivity extends AppCompatActivity {

    public static final String MY_PREF = "myPref";
    public static final String FIRST_NAME_USER_FIELD = "first_name";
    public static final String LAST_NAME_USER_FIELD = "last_name";
    public static final String PHONE_USER_FIELD = "phone";
    public static final String LOGIN_USER_FIELD = "login";
    public static final String PASSWORD_USER_FIELD = "password";
    public static final String REGISTRATION_USER_STATUS = "registrationUserStatus";
    public static final String AUTHORIZATION_USER_STATUS = "authorizationUserStatus";
    public static final String NO_DATA = "NO DATA";

    private static final String CONSTRAINT_LAYOUT_ACTIVITY_TITLE = "constraint";
    private static final String KEY_LOGIN = "login_user";
    private static final String KEY_REGISTRATION = "registration_user";
    private SharedPreferences sPref;
    private Intent mIntent;
    private Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);



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

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        boolean checkLoginUserStatus = loadLoginUserStatus();
        boolean checkRegistrationUserStatus = loadRegistrationUserStatus();
        if (checkLoginUserStatus && checkRegistrationUserStatus) {
            mIntent = new Intent(ConstraintLayoutActivity.this, UserProfileActivity.class);
            startActivity(mIntent);
        }
        
        String value = Objects.requireNonNull(getIntent().getExtras()).getString(CONSTRAINT_LAYOUT_ACTIVITY_TITLE);
        setTitle(value);
    }

    private boolean loadLoginUserStatus() {
        sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        return sPref.getBoolean(AUTHORIZATION_USER_STATUS, false);
    }

    private boolean loadRegistrationUserStatus() {
        sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        return sPref.getBoolean(REGISTRATION_USER_STATUS, false);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
