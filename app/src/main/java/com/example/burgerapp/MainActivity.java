package com.example.burgerapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOk = findViewById(R.id.btnOk);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtFamily = findViewById(R.id.edtFamily);
        EditText edtAge = findViewById(R.id.edtAge);
        EditText edtMail = findViewById(R.id.edtMail);

        //****************Shared preferences***************//
        String existingName=PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("name","");
        String existingFamily=PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("family","");
        String existingAge=PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("age","");
        String existingEmail=PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("mail","");



        edtName.setText(existingName);
        edtFamily.setText(existingFamily);
        edtAge.setText(existingAge);
        edtMail.setText(existingEmail);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtName = findViewById(R.id.edtName);
                EditText edtFamily = findViewById(R.id.edtFamily);
                EditText edtAge = findViewById(R.id.edtAge);
                EditText edtMail = findViewById(R.id.edtMail);
                String p[]=new String[4];
                p[0]=edtName.getText().toString();
                p[1]=edtFamily.getText().toString();
                p[2]=edtAge.getText().toString();
                p[3]=edtMail.getText().toString();


                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                intent.putExtra("name",p[0]);
                intent.putExtra("family",p[1]);
                intent.putExtra("age",p[2]);
                intent.putExtra("mail",p[3]);
                startActivityForResult(intent,4545);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==4545){
            if (resultCode== Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                String name=data.getStringExtra("fname");
                String family=data.getStringExtra("lname");
                String age=data.getStringExtra("age");
                String mail=data.getStringExtra("email");
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("name",name).apply();
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("family", family).apply();
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("age",age).apply();
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("mail",mail).apply();
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();

            }
        }
    }
}
