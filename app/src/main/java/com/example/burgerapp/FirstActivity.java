package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //**********find View By Id init***********//
        TextView txtName = findViewById(R.id.txtName);
        TextView txtFamily = findViewById(R.id.txtFamily);
        TextView txtAge = findViewById(R.id.txtAge);
        TextView txtMail = findViewById(R.id.txtMail);

        Button btnCo = findViewById(R.id.btnCo);
        Button btnEdit = findViewById(R.id.btnEdit);

        //*************Getting Intent***************//

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
         txtName.setText(name);
        final String family = intent.getStringExtra("family");
        txtFamily.setText(family);
        final String age = intent.getStringExtra("age");
        txtAge.setText(age);
        final String mail = intent.getStringExtra("mail");
        txtMail.setText(mail);

        //*************Setting On Click Listener***************//

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEdit = new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intentEdit);
            }
        });
        btnCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForResult = new Intent();
                intentForResult.putExtra("name",name);
                intentForResult.putExtra("family",family);
                intentForResult.putExtra("age",age);
                intentForResult.putExtra("mail",mail);
                intentForResult.putExtra("result","your informatin saved successfully");

                setResult(Activity.RESULT_OK,intentForResult);
                finish();


            }
        });
    }
}
