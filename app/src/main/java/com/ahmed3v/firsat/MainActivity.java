package com.ahmed3v.firsat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.ahmed3v.firsat.adapter.CarAdapter;
import com.ahmed3v.firsat.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    private CarAdapter carAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carList = carArrayList();

        carAdapter = new CarAdapter(this, carList);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(carAdapter);


        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout , R.string.nav_open , R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private ArrayList <Car> carArrayList() {

        ArrayList<Car> list = new ArrayList<>();

        list.add(new Car("https://i0.shbdn.com/photos/41/47/97/x5_863414797l7w.jpg" ,"Fiat - Egea 2017-2018", "السعر اليومي: 250 TL", "السعر الشهري: 4500 TL"));
        list.add(new Car("https://besthqwallpapers.com/Uploads/18-8-2019/101678/thumb2-fiat-egea-sport-4k-2019-cars-motion-blur-fiat-357.jpg" ,"Fiat - Egea 2019", "السعر اليومي: 300 TL", "السعر الشهري: 5000 TL"));
        list.add(new Car( "https://i0.shbdn.com/photos/96/19/94/x5_89396199418l.jpg","Renault - Clio 2018", "السعر اليومي: 250 TL", "السعر الشهري: 4500 TL"));
        list.add(new Car("http://www.arabateknikbilgi.com/wp-content/uploads/2018/01/ArabaTeknikBilgi-2018-Hyundai-Elantra.jpg" ,"Hyundai - Elantra 2018", "السعر اليومي: 300 TL", "السعر الشهري: 6000 TL"));
        list.add(new Car("https://media.autoexpress.co.uk/image/private/s--DLhebqK4--/v1562243256/autoexpress/2016/08/uk-grand-c-max-front-three-quart-dynamic.jpg" ,"Ford - C-Max 2017", "السعر اليومي: 400 TL", "السعر الشهري: 10000 TL"));

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

            if(item.getItemId() == R.id.nav_terms){


            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}