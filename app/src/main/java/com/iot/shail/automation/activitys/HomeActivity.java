package com.iot.shail.automation.activitys;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.iot.shail.automation.fragments.HomeFragment;
import com.iot.shail.automation.fragments.LocationFragment;
import com.iot.shail.automation.adapters.MenuItemAdapter;
import com.iot.shail.automation.R;
import com.iot.shail.automation.fragments.ReportsFragment;
import com.iot.shail.automation.fragments.SettingsFragment;
import com.iot.shail.automation.models.DrawerMenuItemModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class HomeActivity extends AppCompatActivity {

    //******* tool bar variable**********
    private ActionBar actionbar;

    //******* drawer other variable *******
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;

    //********** drawer item using list view ***********************
    private List<DrawerMenuItemModel> drawerMenuItems = new ArrayList<DrawerMenuItemModel>();
    private ListView listView;
    private MenuItemAdapter menuItemAdapter;
    public static final List<Integer> menuItemIcon = Arrays.asList(R.drawable.ic_home,R.drawable.ic_location,R.drawable.ic_reports,R.drawable.ic_settings,R.drawable.ic_logout);
    public static final List<String> menuItemValue = Arrays.asList("Home","Location","Reports","Settings","Logout");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupActionbar();     //***** call setupActionbar Function ********
        setupDrawer();      //***** call setupDrawer Function ********

        //***** set home fragment ********
        HomeFragment homeFragment = new HomeFragment();
        setFragment(homeFragment);
        actionbar.setTitle("Select Location");

        //***** drawer item list view ********
        listView = (ListView) findViewById(R.id.list);
        for (int i = 0; i < 5; i++) {
            DrawerMenuItemModel drawerMenuItemObject = new DrawerMenuItemModel(menuItemIcon.get(i),menuItemValue.get(i));
            drawerMenuItems.add(drawerMenuItemObject);
        }

        menuItemAdapter= new MenuItemAdapter(this, drawerMenuItems);
        listView.setAdapter(menuItemAdapter);
        menuItemAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                switch(position) {
                    case 0:
                        HomeFragment homeFragment = new HomeFragment();
                        refreshFragment(homeFragment);
                        break;
                    case 1:
                        LocationFragment locationFragment = new LocationFragment();
                        setFragment(locationFragment);
                        actionbar.setTitle("Location");
                        break;
                    case 2:
                        ReportsFragment reportsFragment= new ReportsFragment();
                        setFragment(reportsFragment);
                        actionbar.setTitle("Reports");
                        break;
                    case 3:
                        SettingsFragment settingsFragment = new SettingsFragment();
                        setFragment(settingsFragment);
                        actionbar.setTitle("Settings");
                        break;
                    case 4:
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        HomeActivity.this.finish();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Wrong Item Click", Toast.LENGTH_LONG).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    //*************** set fragment method ****************
    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //****** end ****************

    //*************** refrace fragment method ****************
    public void refreshFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        actionbar.setTitle("Select Location");

        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    //****** end ****************

    //******* menu bar created **********
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (id) {
            case R.id.home_icon:
                HomeFragment homeFragment = new HomeFragment();
                refreshFragment(homeFragment);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //******* menu bar end **********

    //************* setup toolbar ****************
    private void setupActionbar() {
        actionbar = getSupportActionBar();
        assert actionbar != null;
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //************* end ****************

    //************* setup drawer ****************
    private void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
            }
            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
    //************* end ****************

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    //************* when press back button ****************
    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }else if(fragments == 1)
        {
            ViewGroup viewGroup = findViewById(android.R.id.content);
            View dialogView = LayoutInflater.from(this).inflate(R.layout.exit_alert_dialog, viewGroup, false);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(dialogView);
            builder.setCancelable(false);
            final AlertDialog alertDialog = builder.create();
            alertDialog.show();

            Button no = dialogView.findViewById(R.id.no_button);
            Button yes =dialogView.findViewById(R.id.yes_button);

            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    HomeActivity.this.finish();
                }
            });
        } else {
            super.onBackPressed();
        }
    }
}