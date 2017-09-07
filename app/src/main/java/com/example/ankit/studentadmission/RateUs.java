package com.example.ankit.studentadmission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by Ankit on 8/31/2016.
 */
public class RateUs extends AppCompatActivity {

    private static Button button_submit;
    private static RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        OnButtonClickListener();
    }

    public void OnButtonClickListener() {
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        button_submit = (Button)findViewById(R.id.button6);

        button_submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(RateUs.this, "Thanks for your Rating", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

