package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;
import static com.example.vinsergey.androidjavaexample.Layouts.Constraint.Constants.*;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TEXT_REGISTRATION_USER = "registration_user";
    private static final String TEXT_USER_REGISTERED = "User already registered, sign in";

    private EditText firstName, lastName, phone, login, password, confirmPassword;
    TextInputLayout firstNameLayout, lastNameLayout, phoneLayout, loginLayout, passwordLayout, confirmPasswordLayout;
    private Intent intent;
    private SharedPreferences sPref;
    private Animation shakeAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String value = Objects.requireNonNull(getIntent().getExtras()).getString(TEXT_REGISTRATION_USER);
        setTitle(value);

        firstName = findViewById(R.id.input_first_name_registration);
        lastName = findViewById(R.id.input_last_name_registration);
        phone = findViewById(R.id.input_phone_registration);
        login = findViewById(R.id.input_login_user_registration);
        password = findViewById(R.id.input_password_user_registration);
        confirmPassword = findViewById(R.id.input_confirm_password_registration);

        firstNameLayout = findViewById(R.id.input_first_name_registration_layout);
        lastNameLayout = findViewById(R.id.input_last_name_registration_layout);
        phoneLayout = findViewById(R.id.input_phone_registration_layout);
        loginLayout = findViewById(R.id.input_login_user_registration_layout);
        passwordLayout = findViewById(R.id.input_password_user_registration_layout);
        confirmPasswordLayout = findViewById(R.id.input_confirm_password_registration_layout);

        Button btnRegistration = findViewById(R.id.btn_registration_user);

        shakeAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loadRegistrationUserStatus()) {
                    Toast.makeText(getApplicationContext(), TEXT_USER_REGISTERED, Toast.LENGTH_LONG).show();
                } else {
                    if (submitForm()) {
                        registrationNewUser();
                        intent = new Intent(getApplicationContext(), UserProfileActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean loadRegistrationUserStatus() {
        sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        return sPref.getBoolean(REGISTRATION_USER_STATUS, false);
    }

    private void registrationNewUser() {
        sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(FIRST_NAME_USER_FIELD, firstName.getText().toString());
        ed.putString(LAST_NAME_USER_FIELD, lastName.getText().toString());
        ed.putString(PHONE_USER_FIELD, phone.getText().toString());
        ed.putString(LOGIN_USER_FIELD, login.getText().toString());
        ed.putString(PASSWORD_USER_FIELD, password.getText().toString());
        ed.putBoolean(REGISTRATION_USER_STATUS, true);
        ed.putBoolean(AUTHORIZATION_USER_STATUS, true);
        ed.apply();
    }

    private boolean submitForm() {
        if (!checkFirstName()) {
            firstName.setAnimation(shakeAnim);
            firstName.startAnimation(shakeAnim);
            return false;
        }

        if (!checkLastName()) {
            lastName.setAnimation(shakeAnim);
            lastName.startAnimation(shakeAnim);
            return false;
        }

        if (!checkPhone()) {
            phone.setAnimation(shakeAnim);
            phone.startAnimation(shakeAnim);
            return false;
        }

        if (!checkLogin()) {
            login.setAnimation(shakeAnim);
            login.startAnimation(shakeAnim);
            return false;
        }

        if (!checkPassword()) {
            password.setAnimation(shakeAnim);
            password.startAnimation(shakeAnim);
            return false;
        }

        if (!checkConfirmPassword()) {
            confirmPassword.setAnimation(shakeAnim);
            confirmPassword.startAnimation(shakeAnim);
            return false;
        }
        firstNameLayout.setErrorEnabled(false);
        loginLayout.setErrorEnabled(false);
        phoneLayout.setErrorEnabled(false);
        loginLayout.setErrorEnabled(false);
        passwordLayout.setErrorEnabled(false);
        confirmPasswordLayout.setErrorEnabled(false);

        return true;
    }

    private boolean checkFirstName() {
        if (firstName.getText().toString().trim().isEmpty()) {
            firstNameLayout.setErrorEnabled(true);
            firstNameLayout.setError("Enter first name");
            firstName.setError("Valid Input Required");
            return false;
        }
        firstNameLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkLastName() {
        if (lastName.getText().toString().trim().isEmpty()) {
            lastNameLayout.setErrorEnabled(true);
            lastNameLayout.setError("Enter last name");
            lastName.setError("Valid Input Required");
            return false;
        }
        lastNameLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkPhone() {
        if (phone.getText().toString().trim().isEmpty()) {
            phoneLayout.setErrorEnabled(true);
            phoneLayout.setError("Enter phone");
            phone.setError("Valid Input Required");
            return false;
        }
        phoneLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkLogin() {
        if (login.getText().toString().trim().isEmpty()) {
            loginLayout.setErrorEnabled(true);
            loginLayout.setError("Enter login");
            login.setError("Valid Input Required");
            return false;
        }
        loginLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkPassword() {
        if (password.getText().toString().trim().isEmpty()) {
            passwordLayout.setErrorEnabled(true);
            passwordLayout.setError("Enter password");
            password.setError("Valid Input Required");
            return false;
        }
        passwordLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkConfirmPassword() {
        if (!password.getText().toString().equals(confirmPassword.getText().toString().trim())) {
            confirmPasswordLayout.setErrorEnabled(true);
            confirmPasswordLayout.setError("Passwords not Equals");
            confirmPassword.setError("Valid Input Required");
            return false;
        }
        confirmPasswordLayout.setErrorEnabled(false);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
