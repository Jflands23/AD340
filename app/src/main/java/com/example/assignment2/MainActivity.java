package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView bioView;
    TextView nameView;
    TextView jobView;
    DatePicker dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToSubmission(View view) {
        dob = findViewById(R.id.dob);
        bioView = findViewById(R.id.bio);
        nameView = findViewById(R.id.name);
        textView = findViewById(R.id.username);
        jobView = findViewById(R.id.job);
        if(textView.getText().toString().matches("")){
            textView.setError("Cannot Be Blank!");
            return;
        }
        Intent intent = new Intent(MainActivity.this, Submission.class);
        Bundle bundle = new Bundle();

        String user = textView.getText().toString();
        String bio = bioView.getText().toString();
        String name = nameView.getText().toString();
        String job = jobView.getText().toString();
        bundle.putString(Constants.KEY_USER, user);
        bundle.putString(Constants.KEY_NAME, name);
        bundle.putString(Constants.KEY_BIO, bio);
        bundle.putString(Constants.KEY_JOB, job);
        intent.putExtras(bundle);
        startActivity(intent);



    }
}