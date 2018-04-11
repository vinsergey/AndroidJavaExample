package com.example.vinsergey.androidjavaexample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.vinsergey.androidjavaexample.Buttons.ButtonActivity;
import com.example.vinsergey.androidjavaexample.EditText.EditTextActivity;
import com.example.vinsergey.androidjavaexample.Layouts.LayoutsActivity;
import com.example.vinsergey.androidjavaexample.TextView.TextViewActivity;
import com.example.vinsergey.androidjavaexample.databinding.ActivityMainDrawerBinding;
import java.util.jar.Manifest;

public class MainDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String KEY_LAYOUT = "layout";
    private static final String KEY_BUTTON = "button";
    private static final String KEY_TEXT_VIEW = "text_view";
    private static final String KEY_EDIT_TEXT = "edit_text";

    private ActivityMainDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        binding.navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_light_theme) {
            //TODO changer style
            setTheme(R.style.AppTheme);
        } else if (id == R.id.action_dark_theme) {
            setTheme(R.style.AppThemeDark);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent mIntent;
        Bundle mBundle;
        if (id == R.id.nav_layout) {
            mIntent = new Intent(this, LayoutsActivity.class);
            mBundle = new Bundle();
            mBundle.putString(KEY_LAYOUT, getResources().getString(R.string.btn_layout));
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        } else if (id == R.id.nav_button) {
            mIntent = new Intent(this, ButtonActivity.class);
            mBundle = new Bundle();
            mBundle.putString(KEY_BUTTON, getResources().getString(R.string.btn_button));
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        } else if (id == R.id.nav_text_view) {
            mIntent = new Intent(this, TextViewActivity.class);
            mBundle = new Bundle();
            mBundle.putString(KEY_TEXT_VIEW, getResources().getString(R.string.btn_text_view));
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        } else if (id == R.id.nav_edit_text) {
            mIntent = new Intent(this, EditTextActivity.class);
            mBundle = new Bundle();
            mBundle.putString(KEY_EDIT_TEXT, getResources().getString(R.string.btn_edit_text));
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
