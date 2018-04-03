package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class UserProfileActivity extends AppCompatActivity {

    private TextView textFirstName, textLastName, textPhone, textLogin, textPassword;
    private SharedPreferences sPref;
    private static final String MY_PREF = "myPref";
    private static final String AUTHORIZATION_USER_STATUS = "authorizationUserStatus";
    private static final String REGISTRATION_USER_STATUS = "registrationUserStatus";
    private static final String FIRST_NAME_USER_FIELD = "first_name";
    private static final String LAST_NAME_USER_FIELD = "last_name";
    private static final String PHONE_USER_FIELD = "phone";
    private static final String LOGIN_USER_FIELD = "login";
    private static final String PASSWORD_USER_FIELD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setTitle("User Profile");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        textFirstName = findViewById(R.id.output_text_first_name);
        textLastName = findViewById(R.id.output_text_last_name);
        textPhone = findViewById(R.id.output_text_phone);
        textLogin = findViewById(R.id.output_text_login);
        textPassword = findViewById(R.id.output_text_password);
        Button btnLogout = findViewById(R.id.btn_logout);
        Button btnDeleteUser = findViewById(R.id.btn_delete_user);

        loadData();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putBoolean(AUTHORIZATION_USER_STATUS, false);
                ed.apply();
                finish();
//                Intent intent = new Intent(UserProfileActivity.this, ConstraintLayoutActivity.class);
//                startActivity(intent);
            }
        });

        btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putBoolean(AUTHORIZATION_USER_STATUS, false);
                ed.putBoolean(REGISTRATION_USER_STATUS, false);
                ed.apply();
                finish();
//                Intent intent = new Intent(UserProfileActivity.this, ConstraintLayoutActivity.class);
//                startActivity(intent);
            }
        });

    }

    private void loadData() {
        sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        String firstNameUserField = sPref.getString(FIRST_NAME_USER_FIELD, "NO DATA");
        String lastNameUserField = sPref.getString(LAST_NAME_USER_FIELD, "NO DATA");
        String phoneUserField = sPref.getString(PHONE_USER_FIELD, "NO DATA");
        String loginUserField = sPref.getString(LOGIN_USER_FIELD, "NO DATA");
        String passwordUserField = sPref.getString(PASSWORD_USER_FIELD, "NO DATA");

        textFirstName.setText(firstNameUserField);
        textLastName.setText(lastNameUserField);
        textPhone.setText(phoneUserField);
        textLogin.setText(loginUserField);
        textPassword.setText(passwordUserField);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
