package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityLoginBinding;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;
import static com.example.vinsergey.androidjavaexample.Layouts.Constraint.Constants.*;

public class LoginActivity extends AppCompatActivity {

    private static final String LOGIN_ACTIVITY_TITLE = "login_user";

    private Intent intent;
    private SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);

        final ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(LOGIN_ACTIVITY_TITLE);
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        binding.btnLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                String userLoginField = binding.inputLogin.getText().toString();
                String userPasswordField = binding.inputPassword.getText().toString();
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
                    Toast.makeText(LoginActivity.this, getString(R.string.text_user_not_registered), Toast.LENGTH_LONG).show();
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
