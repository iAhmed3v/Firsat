package com.ahmed3v.firsat.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.ahmed3v.firsat.R;
import com.ahmed3v.firsat.adapter.CarAdapter;
import com.ahmed3v.firsat.model.Car;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

/*
The Main Activity implements a NavigationView to display some menu items.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    private CarAdapter carAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create car array list object
        carList = carArrayList();

        //create car adapter object
        carAdapter = new CarAdapter(this, carList);

        //initialize recyclerview
        recyclerView = findViewById(R.id.recycler_view);

        //set layout for the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set adapter for recycler view
        recyclerView.setAdapter(carAdapter);

        //create toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        //create navigation view and set item listener for it.
        NavigationView navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);


        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout , R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.nav_terms:
                Intent termsIntent = new Intent(MainActivity.this, TermsActivity.class);
                startActivity(termsIntent);
                break;

            case R.id.nav_contact_us:
                Uri number = Uri.parse("tel:+905538918619");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
                break;

            case R.id.nav_location:
                Uri location = Uri.parse("https://goo.gl/maps/Gj4dxRwgwZRGZYoE7");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
                break;

            case R.id.nav_app_info:
                Intent appInfoIntent = new Intent(MainActivity.this, AppInfoActivity.class);
                startActivity(appInfoIntent);
                break;

            case R.id.nav_developer_info:
                Intent devInfoIntent = new Intent(MainActivity.this, DevInfoActivity.class);
                startActivity(devInfoIntent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    //if the Drawer is open and the user pressed the back button
    //we want to close the drawer first not the app
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);

        }else {
            super.onBackPressed();
        }
    }

    private ArrayList <Car> carArrayList() {

        //create some array list objects and give them values.
        //Note: WE SHOULD CHANGE THIS APPROACH ASAP
        ArrayList<Car> list = new ArrayList<>();

        list.add(new Car("https://i0.shbdn.com/photos/41/47/97/x5_863414797l7w.jpg" ,"Fiat - Egea 2017-2018", getString(R.string.fiat_17_18_daily_price), getString(R.string.fiat_17_18_monthly_price)));
        list.add(new Car("https://besthqwallpapers.com/Uploads/18-8-2019/101678/thumb2-fiat-egea-sport-4k-2019-cars-motion-blur-fiat-357.jpg" ,"Fiat - Egea 2019", getString(R.string.fiat_19_daily_price), getString(R.string.fiat_19_monthly_price)));
        list.add(new Car( "https://i0.shbdn.com/photos/96/19/94/x5_89396199418l.jpg","Renault - Clio 2018", getString(R.string.clio_18_daily_price), getString(R.string.clio_18_monthly_price)));
        list.add(new Car("http://www.arabateknikbilgi.com/wp-content/uploads/2018/01/ArabaTeknikBilgi-2018-Hyundai-Elantra.jpg" ,"Hyundai - Elantra 2018", getString(R.string.elantra_18_daily_price), getString(R.string.elantra_18_monthly_price)));
        list.add(new Car("https://media.autoexpress.co.uk/image/private/s--DLhebqK4--/v1562243256/autoexpress/2016/08/uk-grand-c-max-front-three-quart-dynamic.jpg" ,"Ford - C-Max 2017", getString(R.string.ford_17_daily_price), getString(R.string.ford_17_monthly_price)));

        return list;
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {

        }
        return super.onOptionsItemSelected(item);
    }

}