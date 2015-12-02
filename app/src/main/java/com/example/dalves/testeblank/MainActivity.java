package com.example.dalves.testeblank;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = ((DrawerLayout) findViewById(R.id.drawer_layout));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);

        drawerLayout.setDrawerListener(new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close));

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TabFragment()).commit();
        ((NavigationView) findViewById(R.id.nav_view)).setCheckedItem(R.id.nav_home);
        setupDrawerContent((NavigationView) findViewById(R.id.nav_view));
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        onDrawerItemSelected(menuItem);
                        return true;
                    }
                });
    }

    private void onDrawerItemSelected(MenuItem menuItem) {

        setTitle(menuItem.getTitle());
        if (menuItem.getItemId() == R.id.nav_messages) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new NonTabFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new TabFragment()).commit();
        }
    }
}
