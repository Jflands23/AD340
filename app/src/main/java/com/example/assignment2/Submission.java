package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

;

public class Submission extends AppCompatActivity{
    TextView textView;
    TextView bioView;
    TextView nameView;
    TextView jobView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submission);
        textView = findViewById(R.id.submission);
        bioView = findViewById(R.id.bio);
        nameView = findViewById(R.id.name);
        jobView = findViewById(R.id.job);
        StringBuilder msg = new StringBuilder("Thanks for Signing Up ");

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        String name = "Example Name";
        String bio = "";

        if(b != null){
            if(b.containsKey(Constants.KEY_USER)) {
                name = b.getString(Constants.KEY_USER);
                msg.append(name);
            }
            if(b.containsKey((Constants.KEY_BIO))) {
                bioView.setText(b.getString(Constants.KEY_BIO));
            }
            if(b.containsKey((Constants.KEY_NAME))) {
               nameView.setText(b.getString(Constants.KEY_NAME));
            }
            if(b.containsKey((Constants.KEY_JOB))) {
                jobView.setText(b.getString(Constants.KEY_JOB));
            }
        }

        textView.setText(msg);


    }


}
