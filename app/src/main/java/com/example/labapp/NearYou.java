package com.example.labapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NearYou extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationClient;
    LinearLayout myLayout;
    List<Seller> sells;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_you);
        SensorManager sensorManager;
        myLayout  = findViewById(R.id.linearLayoutNear);
        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("Request permission");

        } else {
            // already permission granted
        sells = new ArrayList<Seller>();

        sells.add(new Seller(45.9,27.3,"Marian","Tiguan"));
        sells.add(new Seller(45.79,27.47,"Marcel","Passat"));
        sells.add(new Seller(45.17,27.01,"Alexandru","Audi A3"));
        sells.add(new Seller(50.53,38.33,"Pavel","Lada"));
        TextView location_lat = new TextView(this);
        TextView location_lon = new TextView(this);
            fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        System.out.println("Hello?");
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            printSellers(location);
                        }
                        else{
                            System.out.println("can't get locations..");
                        }
                    }
                });
        }
//        int i=1;
//        for (Sensor s : deviceSensors){
//            TextView x = new TextView(this);
//            x.setText(s.getName());
//            x.setId(R.id.parent+i);
//            i++;
////            System.out.println(x.getText());
//            myLayout.addView(x);
//        }

//        View itemView = LayoutInflater.inflate(R.layout.card_car, parent, false);
//
//        Button myButton = new Button(this);
//        myButton.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//
//        myLayout.addView(myButton);

    }
    public void printSellers(Location l ){
        Location dest= new Location("");
        boolean added = false;
        for ( Seller i : sells){
            dest.setLongitude(i.longitude);
            dest.setLatitude(i.latitude);
            System.out.println(l.distanceTo(dest));
            if (l.distanceTo(dest)<30000){
                TextView x = new TextView(this);
                x.setText(i.getData());
                myLayout.addView(x);
                added=true;
            }
        }
        if (added==false) {
            TextView x = new TextView(this);
            x.setText("No sellers nearby..");
            myLayout.addView(x);
        }
    }

}
