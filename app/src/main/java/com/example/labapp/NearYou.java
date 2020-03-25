package com.example.labapp;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class NearYou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_you);
        LinearLayout myLayout = findViewById(R.id.linearLayoutNear);
        SensorManager sensorManager;
        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s : deviceSensors){
            TextView x = new TextView(this);
            x.setText(s.getName());
            x.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            x.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            x.setId(R.id.parent+1);
            System.out.println(x.getText());
            myLayout.addView(x);
        }

//        View itemView = LayoutInflater.inflate(R.layout.card_car, parent, false);
//
//        Button myButton = new Button(this);
//        myButton.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//
//        myLayout.addView(myButton);

    }

}
