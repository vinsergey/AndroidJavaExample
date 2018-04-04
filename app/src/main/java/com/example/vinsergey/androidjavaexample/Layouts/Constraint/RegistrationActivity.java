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
import static com.example.vinsergey.androidjavaexample.Layouts.Constraint.ConstraintLayoutActivity.*;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TEXT_REGISTRATION_USER = "registration_user";
    private static final String TEXT_INPUT_ALL_FIELDS = "Input all fields";
    private static final String TEXT_PASSWORD_NOT_EQUALS = "Passwords not equals";
    private static final String TEXT_USER_REGISTERED = "User already registered, sign in";
    private EditText firstName, lastName, phone, login, password, confirmPassword;
    private Intent intent;
    private SharedPreferences sPref;

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
        Button btnRegistration = findViewById(R.id.btn_login_user_registration);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkRegistrationStatus = loadRegistrationUserStatus();
                if (checkRegistrationStatus) {
                    Toast.makeText(RegistrationActivity.this, TEXT_USER_REGISTERED, Toast.LENGTH_LONG).show();
                } else {
                    boolean checkUserEnterFields = checkUserEnterFields();
                    if (checkUserEnterFields) {
                        registrationNewUser();
                        intent = new Intent(RegistrationActivity.this, UserProfileActivity.class);
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
        String firstNameUser = firstName.getText().toString();
        String lastNameUser = lastName.getText().toString();
        String phoneUser = phone.getText().toString();
        String loginUser = login.getText().toString();
        String passwordUser = password.getText().toString();

        sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
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
            Toast.makeText(this, TEXT_INPUT_ALL_FIELDS, Toast.LENGTH_LONG).show();
            return false;
        } else if (!passwordUser.equals(confirmPasswordUser)) {
            Toast.makeText(this, TEXT_PASSWORD_NOT_EQUALS, Toast.LENGTH_LONG).show();
            return false;
        } else return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
