package com.example.ankit.studentadmission;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class displaydetails extends AppCompatActivity {

    private SQLiteDatabase db;
    TextView name, contact, gender, birth, address, username;
    Cursor c;
    String id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaydetails);

        name = (TextView)findViewById(R.id.textView2);
        contact = (TextView)findViewById(R.id.textView6);
        gender = (TextView)findViewById(R.id.textView8);
        birth = (TextView)findViewById(R.id.textView10);
        address = (TextView)findViewById(R.id.textView12);
        username = (TextView)findViewById(R.id.textView14);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("Id");
        CreateDatabase();
        showData();
    }

    protected void CreateDatabase() {

        db = openOrCreateDatabase("StudentAdmission", MODE_PRIVATE, null);
    }

    public void showData() {

        c = db.rawQuery("select * from StudentDetails where id= '"+id+"'",null);

        while(c.moveToNext()) {

            name.setText(c.getString(1));
            contact.setText(c.getString(2));
            gender.setText(c.getString(3));
            birth.setText(c.getString(4));
            address.setText(c.getString(5));
            username.setText(c.getString(6));
        }
    }

    public void logout(View v) {

        finish();
    }
}