package com.example.user.lifeplant;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.user.lifeplant.Fragment.CartFragment;
import com.example.user.lifeplant.Fragment.LoginFragment;
import com.example.user.lifeplant.Fragment.ProductFragment;
import com.example.user.lifeplant.Fragment.SignupFragment;
import com.example.user.lifeplant.Models.PrefManager;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private String email;
    private TextView navEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new PrefManager(this).getEmail();
        SharedPreferences detail= getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        email=detail.getString("Email","");
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_menu);

           navEmail= navigationView.getHeaderView(0).findViewById(R.id.nav_email);
           navEmail.setText(email);

        replaceFragment(new ProductFragment());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.menu_drawer_login:
                        addFragment(new LoginFragment());
                        break;
                    case R.id.menu_drawer_signup:
                        addFragment(new SignupFragment());
                        break;
                    case R.id.menu_drawer_home:
                        addFragment(new ProductFragment());
                        break;
                    case R.id.menu_drawer_cart:
                        addFragment(new CartFragment());
                        break;
                }
                return false;
            }
        });


    }


    private void replaceFragment(final Fragment fragment) {
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_container, fragment, fragment.getClass().getSimpleName());

        ft.commit();
    }

    private void addFragment(final Fragment fragment) {
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.main_container, fragment, fragment.getClass().getSimpleName());
        ft.addToBackStack(null);
        Fragment currentFragment = fm.findFragmentById(R.id.main_container);
        ft.hide(currentFragment);
        ft.commit();
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }


}
