package com.example.vinsergey.androidjavaexample.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.example.vinsergey.androidjavaexample.R;
import java.util.Objects;

public class TextViewActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_text_view);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString("text_view");
        setTitle(value);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        actv = findViewById(R.id.complete);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, autos);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
