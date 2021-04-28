package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView bioView;
    DatePicker dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToSubmission(View view) {
        dob = findViewById(R.id.dob);
        bioView = findViewById(R.id.bio);
        textView = findViewById(R.id.username);
        if(textView.getText().toString().matches("")){
            textView.setError("Cannot Be Blank!");
            return;
        }
        Intent intent = new Intent(MainActivity.this, Submission.class);
        Bundle bundle = new Bundle();

        String user = textView.getText().toString();
        String bio = bioView.getText().toString();
        bundle.putString(Constants.KEY_NAME, user);
        bundle.putString(Constants.KEY_BIO, bio);
        intent.putExtras(bundle);
        startActivity(intent);



    }
}