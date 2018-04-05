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
import static com.example.vinsergey.androidjavaexample.Layouts.Constraint.Constants.*;

public class LoginActivity extends AppCompatActivity {

    private static final String LOGIN_ACTIVITY_TITLE = "login_user";
    private static final String TEXT_USER_NOT_REGISTER = "User not register";

    private EditText input_login, input_password;
    private Intent intent;
    private SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String value = Objects.requireNonNull(getIntent().getExtras()).getString(LOGIN_ACTIVITY_TITLE);
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        input_login = findViewById(R.id.input_login);
        input_password = findViewById(R.id.input_password);
        Button btn_login = findViewById(R.id.btn_login_user);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                String userLoginField = input_login.getText().toString();
                String userPasswordField = input_password.getText().toString();
                String loginUserField = sPref.getString(LOGIN_USER_FIELD, NO_DATA);
                String passwordUserField = sPref.getString(PASSWORD_USER_FIELD, NO_DATA);

                if (loginUserField.equals(userLoginField) && passwordUserField.equals(userPasswordField)) {
                    sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putBoolean(AUTHORIZATION_USER_STATUS, true);
                    ed.apply();
                    intent = new Intent(LoginActivity.this, UserProfileActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, TEXT_USER_NOT_REGISTER, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
