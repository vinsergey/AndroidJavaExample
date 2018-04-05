package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;
import static com.example.vinsergey.androidjavaexample.Layouts.Constraint.Constants.*;

public class UserProfileActivity extends AppCompatActivity {

    private static final String PROFILE_ACTIVITY_TITLE = "User Profile";
    private static final String TEXT_BASE_DELETED = "Base Deleted!";
    private static final String KEY_CONSTRAINT_LAYOUT = "constraint";

    private TextView textFirstName, textLastName, textPhone, textLogin, textPassword;
    private SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setTitle(PROFILE_ACTIVITY_TITLE);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        textFirstName = findViewById(R.id.output_text_first_name);
        textLastName = findViewById(R.id.output_text_last_name);
        textPhone = findViewById(R.id.output_text_phone);
        textLogin = findViewById(R.id.output_text_login);
        textPassword = findViewById(R.id.output_text_password);
        Button btnLogout = findViewById(R.id.btn_logout);
        Button btnDeleteUser = findViewById(R.id.btn_delete_user);
        Button btnDestroyBase = findViewById(R.id.btn_destroy_base);

        loadData();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putBoolean(AUTHORIZATION_USER_STATUS, false);
                ed.apply();
                finish();
                Intent intent = new Intent(UserProfileActivity.this, ConstraintLayoutActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString(KEY_CONSTRAINT_LAYOUT, getResources().getString(R.string.btn_constraint_layout));
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });

        btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.clear();
                ed.apply();
                finish();
                Intent intent = new Intent(UserProfileActivity.this, ConstraintLayoutActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString(KEY_CONSTRAINT_LAYOUT, getResources().getString(R.string.btn_constraint_layout));
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });

        btnDestroyBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.remove(MY_PREF);
                if (ed.commit()) {
                    Toast.makeText(UserProfileActivity.this, TEXT_BASE_DELETED, Toast.LENGTH_LONG).show();
                    finish();
                    Intent intent = new Intent(UserProfileActivity.this, ConstraintLayoutActivity.class);
                    Bundle mBundle = new Bundle();
                    mBundle.putString(KEY_CONSTRAINT_LAYOUT, getResources().getString(R.string.btn_constraint_layout));
                    intent.putExtras(mBundle);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadData() {
        sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        String firstNameUserField = sPref.getString(FIRST_NAME_USER_FIELD, NO_DATA);
        String lastNameUserField = sPref.getString(LAST_NAME_USER_FIELD, NO_DATA);
        String phoneUserField = sPref.getString(PHONE_USER_FIELD, NO_DATA);
        String loginUserField = sPref.getString(LOGIN_USER_FIELD, NO_DATA);
        String passwordUserField = sPref.getString(PASSWORD_USER_FIELD, NO_DATA);

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
