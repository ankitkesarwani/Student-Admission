package com.example.ankit.studentadmission;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class createdet extends AppCompatActivity {

    private SQLiteDatabase db;
    EditText name, contact, gender, birth, address, username, password, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createdet);

        name = (EditText)findViewById(R.id.editText3);
        contact = (EditText)findViewById(R.id.editText5);
        gender = (EditText)findViewById(R.id.editText6);
        birth = (EditText)findViewById(R.id.editText7);
        address = (EditText)findViewById(R.id.editText8);
        username = (EditText)findViewById(R.id.editText9);
        password = (EditText)findViewById(R.id.editText11);
        confirm = (EditText)findViewById(R.id.editText10);
        CreateDatabase();
    }

    protected void CreateDatabase() {

        db = openOrCreateDatabase("StudentAdmission", MODE_PRIVATE, null);
        db.execSQL("create table if not exists StudentDetails(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name varchar, contact varchar, gender varchar, birth varchar, address varchar,username varchar, password varchar);");
        Toast.makeText(createdet.this, "Create Table And DataBase Successfully", Toast.LENGTH_LONG).show();
    }

    public void SaveData(View v) {

        if(!password.getText().toString().equals(confirm.getText().toString())) {

            Toast.makeText(createdet.this,"Password did not match(Password & confirm password must be Equal)",Toast.LENGTH_LONG).show();
        }
        else if(name.getText().toString().equals("") || contact.getText().toString().equals("") || gender.getText().toString().equals("") || birth.getText().toString().equals("") || address.getText().toString().equals("") || username.getText().toString().equals("") || password.getText().toString().equals("")){

            Toast.makeText(createdet.this,"Please fill all column",Toast.LENGTH_LONG).show();
        }
        else {

            db.execSQL("insert into StudentDetails(name, contact, gender, birth, address, username, password) values('"+name.getText().toString()+"', '"+contact.getText().toString()+"', '"+gender.getText().toString()+"', '"+birth.getText().toString()+"', '"+address.getText().toString()+"', '"+username.getText().toString()+"', '"+password.getText().toString()+"')");
            Toast.makeText(createdet.this, "Record Saved Successfully", Toast.LENGTH_LONG).show();
        }
    }

    public void Back(View v) {

        Intent i = new Intent(createdet.this, login.class);
        startActivity(i);
    }
}