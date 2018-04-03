package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinsergey.androidjavaexample.R;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {

    private static final String MY_PREF = "myPref";
    private static final String FIRST_NAME_USER_FIELD = "first_name";
    private static final String LAST_NAME_USER_FIELD = "last_name";
    private static final String PHONE_USER_FIELD = "phone";
    private static final String LOGIN_USER_FIELD = "login";
    private static final String PASSWORD_USER_FIELD = "password";
    private static final String REGISTRATION_USER_STATUS = "registrationUserStatus";
    private static final String AUTHORIZATION_USER_STATUS = "authorizationUserStatus";
    private EditText firstName, lastName, phone, login, password, confirmPassword;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String value = Objects.requireNonNull(getIntent().getExtras()).getString("registration_user");
        setTitle(value);

        firstName = findViewById(R.id.input_first_name_registration);
        lastName = findViewById(R.id.input_last_name_registration);
        phone = findViewById(R.id.input_phone_registration);
        login = findViewById(R.id.input_login_user_registration);
        password = findViewById(R.id.input_password_user_registration);
        confirmPassword = findViewById(R.id.input_confirm_password_registration);
        Button btnRegistration = findViewById(R.id.btn_login_user_registration);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkUserEnterFields = checkUserEnterFields();
                if (checkUserEnterFields) {
                    registrationNewUser();
                    intent = new Intent(RegistrationActivity.this, UserProfileActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void registrationNewUser() {
        String firstNameUser = firstName.getText().toString();
        String lastNameUser = lastName.getText().toString();
        String phoneUser = phone.getText().toString();
        String loginUser = login.getText().toString();
        String passwordUser = password.getText().toString();

        SharedPreferences mPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        SharedPreferences.Editor ed = mPref.edit();
        ed.putString(FIRST_NAME_USER_FIELD, firstNameUser);
        ed.putString(LAST_NAME_USER_FIELD, lastNameUser);
        ed.putString(PHONE_USER_FIELD, phoneUser);
        ed.putString(LOGIN_USER_FIELD, loginUser);
        ed.putString(PASSWORD_USER_FIELD, passwordUser);
        ed.putBoolean(REGISTRATION_USER_STATUS, true);
        ed.putBoolean(AUTHORIZATION_USER_STATUS, true);
        ed.apply();
    }

    private boolean checkUserEnterFields() {
        String firstNameUser = firstName.getText().toString();
        String lastNameUser = lastName.getText().toString();
        String phoneUser = phone.getText().toString();
        String loginUser = login.getText().toString();
        String passwordUser = password.getText().toString();
        String confirmPasswordUser = confirmPassword.getText().toString();

        if (firstNameUser.isEmpty() || lastNameUser.isEmpty() || phoneUser.isEmpty() || loginUser.isEmpty() ||
                passwordUser.isEmpty() || confirmPasswordUser.isEmpty()) {
            Toast.makeText(this, "Input all fields", Toast.LENGTH_LONG).show();
            return false;
        } else if (!passwordUser.equals(confirmPasswordUser)) {
            Toast.makeText(this, "Passwords not equals", Toast.LENGTH_LONG).show();
            return false;
        } else return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
