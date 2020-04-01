package com.example.labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
public class takePhoto extends AppCompatActivity {
    Button takePictureButton;
    TextureView textureView;
    CameraDevice cam;
    public void takePicture(){
//        Take picture
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        textureView = (TextureView) findViewById(R.id.textureView);
        assert textureView != null;

        takePictureButton = (Button) findViewById(R.id.buttonPhoto);
        assert takePictureButton != null;
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
    }
}
