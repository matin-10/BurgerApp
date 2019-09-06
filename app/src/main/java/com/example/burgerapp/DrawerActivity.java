package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Button btnOpen = findViewById(R.id.btnOpen);
        final DrawerLayout drawerM = findViewById(R.id.drawerM);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            drawerM.openDrawer(Gravity.LEFT);

            }
        });

        TextView txtProfile = findViewById(R.id.txtProfile);
        txtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrawerActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        TextView txtDial = findViewById(R.id.txtDial);
        txtDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DrawerActivity.this,DialActivity.class);
                startActivity(intent1);
            }
        });
    }


}
