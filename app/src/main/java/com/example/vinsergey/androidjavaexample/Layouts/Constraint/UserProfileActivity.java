package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityUserProfileBinding;
import com.example.vinsergey.androidjavaexample.themeSwitcher;

import java.util.Objects;
import static com.example.vinsergey.androidjavaexample.Layouts.Constraint.Constants.*;

public class UserProfileActivity extends AppCompatActivity {

    private static final String PROFILE_ACTIVITY_TITLE = "User Profile";
    private static final String KEY_CONSTRAINT_LAYOUT = "constraint";

    private SharedPreferences sPref;
    private Intent intent;
    private Bundle mBundle;
    private ActivityUserProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (themeSwitcher.getState()) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);

        setTitle(PROFILE_ACTIVITY_TITLE);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);

        loadData();

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putBoolean(AUTHORIZATION_USER_STATUS, false);
                ed.apply();
                finish();
                intent = new Intent(UserProfileActivity.this, ConstraintLayoutActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_CONSTRAINT_LAYOUT, getResources().getString(R.string.btn_constraint_layout));
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });

        binding.btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.clear();
                ed.apply();
                finish();
                intent = new Intent(UserProfileActivity.this, ConstraintLayoutActivity.class);
                mBundle = new Bundle();
                mBundle.putString(KEY_CONSTRAINT_LAYOUT, getResources().getString(R.string.btn_constraint_layout));
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });

        binding.btnDestroyBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.remove(MY_PREF);
                if (ed.commit()) {
                    Toast.makeText(UserProfileActivity.this, getString(R.string.text_base_deleted), Toast.LENGTH_LONG).show();
                    finish();
                    intent = new Intent(UserProfileActivity.this, ConstraintLayoutActivity.class);
                    mBundle = new Bundle();
                    mBundle.putString(KEY_CONSTRAINT_LAYOUT, getResources().getString(R.string.btn_constraint_layout));
                    intent.putExtras(mBundle);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadData() {
        sPref = getSharedPreferences(MY_PREF, MODE_PRIVATE);

        binding.outputTextFirstName.setText(sPref.getString(FIRST_NAME_USER_FIELD, NO_DATA));
        binding.outputTextLastName.setText(sPref.getString(LAST_NAME_USER_FIELD, NO_DATA));
        binding.outputTextPhone.setText(sPref.getString(PHONE_USER_FIELD, NO_DATA));
        binding.outputTextLogin.setText(sPref.getString(LOGIN_USER_FIELD, NO_DATA));
        binding.outputTextPassword.setText(sPref.getString(PASSWORD_USER_FIELD, NO_DATA));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
