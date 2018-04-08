package com.example.vinsergey.androidjavaexample.Layouts.Constraint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityRegistrationBinding;
import java.util.Objects;
import static com.example.vinsergey.androidjavaexample.Layouts.Constraint.Constants.*;

public class RegistrationActivity extends AppCompatActivity {

    private Intent intent;
    private SharedPreferences sPref;
    private Animation shakeAnim;
    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String value = Objects.requireNonNull(getIntent().getExtras()).getString(getString(R.string.text_registration_user));
        setTitle(value);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);

        shakeAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);

        binding.btnRegistrationUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loadRegistrationUserStatus()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.text_user_registered), Toast.LENGTH_LONG).show();
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
        ed.putString(FIRST_NAME_USER_FIELD, binding.inputFirstNameRegistration.getText().toString());
        ed.putString(LAST_NAME_USER_FIELD, binding.inputLastNameRegistration.getText().toString());
        ed.putString(PHONE_USER_FIELD, binding.inputPhoneRegistration.getText().toString());
        ed.putString(LOGIN_USER_FIELD, binding.inputLoginUserRegistration.getText().toString());
        ed.putString(PASSWORD_USER_FIELD, binding.inputPasswordUserRegistration.getText().toString());
        ed.putBoolean(REGISTRATION_USER_STATUS, true);
        ed.putBoolean(AUTHORIZATION_USER_STATUS, true);
        ed.apply();
    }

    private boolean submitForm() {
        if (!checkFirstName()) {
            binding.inputFirstNameRegistration.setAnimation(shakeAnim);
            binding.inputFirstNameRegistration.startAnimation(shakeAnim);
            return false;
        }

        if (!checkLastName()) {
            binding.inputLastNameRegistration.setAnimation(shakeAnim);
            binding.inputLastNameRegistration.startAnimation(shakeAnim);
            return false;
        }

        if (!checkPhone()) {
            binding.inputPhoneRegistration.setAnimation(shakeAnim);
            binding.inputPhoneRegistration.startAnimation(shakeAnim);
            return false;
        }

        if (!checkLogin()) {
            binding.inputLoginUserRegistration.setAnimation(shakeAnim);
            binding.inputLoginUserRegistration.startAnimation(shakeAnim);
            return false;
        }

        if (!checkPassword()) {
            binding.inputPasswordUserRegistration.setAnimation(shakeAnim);
            binding.inputPasswordUserRegistration.startAnimation(shakeAnim);
            return false;
        }

        if (!checkConfirmPassword()) {
            binding.inputConfirmPasswordRegistration.setAnimation(shakeAnim);
            binding.inputConfirmPasswordRegistration.startAnimation(shakeAnim);
            return false;
        }
        binding.inputFirstNameRegistrationLayout.setErrorEnabled(false);
        binding.inputLastNameRegistrationLayout.setErrorEnabled(false);
        binding.inputPhoneRegistrationLayout.setErrorEnabled(false);
        binding.inputLoginUserRegistrationLayout.setErrorEnabled(false);
        binding.inputPasswordUserRegistrationLayout.setErrorEnabled(false);
        binding.inputConfirmPasswordRegistrationLayout.setErrorEnabled(false);

        return true;
    }

    private boolean checkFirstName() {
        if (binding.inputFirstNameRegistration.getText().toString().trim().isEmpty()) {
            binding.inputFirstNameRegistrationLayout.setErrorEnabled(true);
            binding.inputFirstNameRegistrationLayout.setError(getString(R.string.text_enter_first_name));
            binding.inputFirstNameRegistration.setError(getString(R.string.text_valid_input_required));
            return false;
        }
        binding.inputFirstNameRegistrationLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkLastName() {
        if (binding.inputLastNameRegistration.getText().toString().trim().isEmpty()) {
            binding.inputLastNameRegistrationLayout.setErrorEnabled(true);
            binding.inputLastNameRegistrationLayout.setError(getString(R.string.text_enter_last_name));
            binding.inputLastNameRegistration.setError(getString(R.string.text_valid_input_required));
            return false;
        }
        binding.inputLastNameRegistrationLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkPhone() {
        if (binding.inputPhoneRegistration.getText().toString().trim().isEmpty()) {
            binding.inputPhoneRegistrationLayout.setErrorEnabled(true);
            binding.inputPhoneRegistrationLayout.setError(getString(R.string.text_enter_phone));
            binding.inputPhoneRegistration.setError(getString(R.string.text_valid_input_required));
            return false;
        }
        binding.inputPhoneRegistrationLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkLogin() {
        if (binding.inputLoginUserRegistration.getText().toString().trim().isEmpty()) {
            binding.inputLoginUserRegistrationLayout.setErrorEnabled(true);
            binding.inputLoginUserRegistrationLayout.setError(getString(R.string.text_enter_login));
            binding.inputLoginUserRegistration.setError(getString(R.string.text_valid_input_required));
            return false;
        }
        binding.inputLoginUserRegistrationLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkPassword() {
        if (binding.inputPasswordUserRegistration.getText().toString().trim().isEmpty()) {
            binding.inputPasswordUserRegistrationLayout.setErrorEnabled(true);
            binding.inputPasswordUserRegistrationLayout.setError(getString(R.string.text_enter_password));
            binding.inputPasswordUserRegistration.setError(getString(R.string.text_valid_input_required));
            return false;
        }
        binding.inputPasswordUserRegistrationLayout.setErrorEnabled(false);
        return true;
    }

    private boolean checkConfirmPassword() {
        if (!binding.inputPasswordUserRegistration.getText().toString()
                .equals(binding.inputConfirmPasswordRegistration.getText().toString().trim())) {
            binding.inputConfirmPasswordRegistrationLayout.setErrorEnabled(true);
            binding.inputConfirmPasswordRegistrationLayout.setError(getString(R.string.text_passwords_not_equals));
            binding.inputConfirmPasswordRegistration.setError(getString(R.string.text_valid_input_required));
            return false;
        }
        binding.inputConfirmPasswordRegistrationLayout.setErrorEnabled(false);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
