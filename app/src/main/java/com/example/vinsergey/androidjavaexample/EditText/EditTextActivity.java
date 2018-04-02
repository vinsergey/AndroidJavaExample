package com.example.vinsergey.androidjavaexample.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class EditTextActivity extends AppCompatActivity {

    AutoCompleteTextView actv;
    String[] autos = new String[] {
            "Audi",
            "Renault",
            "Mercedes-Benz",
            "Honda",
            "Mazda",
            "Skoda",
            "Nissan",
            "Opel",
            "Tesla",
            "Toyota",
            "Volvo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        actv = findViewById(R.id.complete);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, autos);
        actv.setThreshold(0);
        actv.setAdapter(adapter);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString("edit_text");
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
