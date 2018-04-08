package com.example.vinsergey.androidjavaexample.EditText;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityEditTextBinding;
import java.util.Objects;

public class EditTextActivity extends AppCompatActivity {

    public static final String EDIT_TEXT_LAYOUT_TITLE = "edit_text";
    String[] autos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityEditTextBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_text);

        autos = getResources().getStringArray(R.array.auto);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, autos);
        binding.complete.setThreshold(0);
        binding.complete.setAdapter(adapter);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(EDIT_TEXT_LAYOUT_TITLE);
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
