package com.example.sqlite_database_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, email, password, gender;

    Button register;

    DbHelper DBHELPER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1 = name.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                String gender1 = gender.getText().toString();

                DBHELPER=new DbHelper(getApplicationContext());
                DBHELPER.RegisterUSerHelper(name1,email1,password1,gender1);

                Toast.makeText(MainActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();

                name.setText("");
                email.setText("");
                password.setText("");
                gender.setText("");

            }
        });


    }
}