package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.annotation.SuppressLint;
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

public class LoginActivity extends AppCompatActivity {

    private EditText input_login, input_password;
    private Intent intent;
    private static final String LOGIN_USER_FIELD = "login";
    private static final String PASSWORD_USER_FIELD = "password";
    private SharedPreferences sPref;
    private static final String MY_PREF = "myPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String value = Objects.requireNonNull(getIntent().getExtras()).getString("login_user");
        setTitle(value);

        input_login = findViewById(R.id.input_login);
        input_password = findViewById(R.id.input_password);
        Button btn_login = findViewById(R.id.btn_login_user);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boolean checkUser = checkUser();
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                String userLoginField = input_login.getText().toString();
                String userPasswordField = input_password.getText().toString();
                String loginUserField = sPref.getString(LOGIN_USER_FIELD, "NO DATA");
                String passwordUserField = sPref.getString(PASSWORD_USER_FIELD, "NO DATA");

                if (loginUserField.equals(userLoginField) && passwordUserField.equals(userPasswordField)) {
                    sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putBoolean(LOGIN_USER_FIELD, true);
                    ed.apply();
                    intent = new Intent(LoginActivity.this, UserProfileActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "User not register", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private boolean checkUser() {
        try {
            sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
            String userLoginField = input_login.getText().toString();
            String userPasswordField = input_password.getText().toString();
            String loginUserField = sPref.getString(LOGIN_USER_FIELD, "NO DATA");
            String passwordUserField = sPref.getString(PASSWORD_USER_FIELD, "NO DATA");
            return loginUserField.equals(userLoginField) && passwordUserField.equals(userPasswordField);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
