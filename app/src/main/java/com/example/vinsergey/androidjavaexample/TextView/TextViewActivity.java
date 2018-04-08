package com.example.vinsergey.androidjavaexample.TextView;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.vinsergey.androidjavaexample.R;
import com.example.vinsergey.androidjavaexample.databinding.ActivityTextViewBinding;
import java.util.Objects;
import java.util.Random;

public class TextViewActivity extends AppCompatActivity {

    private static final String TEXT_VIEW_LAYOUT_TITLE = "text_view";

    private Random random;
    private Animation anim = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityTextViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_text_view);

        String value = Objects.requireNonNull(getIntent().getExtras()).getString(TEXT_VIEW_LAYOUT_TITLE);
        setTitle(value);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        binding.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = new Random();
                int num = random.nextInt(5) + 1;
                switch (num) {
                    case 1:
                        anim = AnimationUtils.loadAnimation(TextViewActivity.this, R.anim.myalpha);
                        break;
                    case 2:
                        anim = AnimationUtils.loadAnimation(TextViewActivity.this, R.anim.mycombo);
                        break;
                    case 3:
                        anim = AnimationUtils.loadAnimation(TextViewActivity.this, R.anim.myrotate);
                        break;
                    case 4:
                        anim = AnimationUtils.loadAnimation(TextViewActivity.this, R.anim.myscale);
                        break;
                    case 5:
                        anim = AnimationUtils.loadAnimation(TextViewActivity.this, R.anim.mytrans);
                        break;
                }
                binding.tv.startAnimation(anim);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
