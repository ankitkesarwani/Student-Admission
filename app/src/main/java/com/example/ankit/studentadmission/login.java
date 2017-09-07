package com.example.ankit.studentadmission;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private SQLiteDatabase db;
    EditText username, password;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /**android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setLogo(R.drawable.download);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);**/

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        createDatabase();
    }

    protected void createDatabase() {
        db = openOrCreateDatabase("StudentAdmission", MODE_PRIVATE, null);
    }

    public void open(View v) {

        String usern = "";
        String pass = "";
        String id = "";

        c = db.rawQuery("select id,username,password from StudentDetails where username='"+username.getText().toString()+ "' and password='"+password.getText().toString()+"'",null);
        while(c.moveToNext()) {

            id = c.getString(0);
            usern = c.getString(1);
            pass = c.getString(2);
        }
        if(usern.equals(username.getText().toString()) && pass.equals(password.getText().toString())) {

            AlertDialog.Builder a_builder = new AlertDialog.Builder(login.this);
            final String finalUsern = usern;
            final String finalPass = pass;
            a_builder.setMessage("Save Username and Password !!!")
                    .setCancelable(false)
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            username.setText(finalUsern);
                            password.setText(finalPass);
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert = a_builder.create();
            alert.setTitle("Alert !!!");
            alert.show();

            Intent i = new Intent(login.this, displaydetails.class);
            Bundle bundle=new Bundle();
            bundle.putString("Id",id);
            i.putExtras(bundle);
            startActivity(i);
        }
        else {

            Toast.makeText(login.this,"Username or password you entered is incorrect",Toast.LENGTH_LONG).show();
        }
    }

    public void register(View v) {

        Intent i = new Intent(login.this, createdet.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.contact_id) {
            Intent i = new Intent(login.this, ContactUs.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.about_id) {
            Intent i1 = new Intent(login.this, AboutUs.class);
            startActivity(i1);
        }
        else if(item.getItemId() == R.id.rate_id) {
            Intent i2 = new Intent(login.this, RateUs.class);
            startActivity(i2);
        }
        return super.onOptionsItemSelected(item);
    }
}