package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;;

public class Submission extends AppCompatActivity{
    TextView textView;
    TextView bioView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submission);
        textView = findViewById(R.id.submission);
        bioView = findViewById(R.id.bio);

        StringBuilder msg = new StringBuilder("Thanks for Signing Up ");

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        String name = "Example Name";
        String bio = "";

        if(b != null){
            if(b.containsKey(Constants.KEY_NAME)) {
                name = b.getString(Constants.KEY_NAME);
                msg.append(name);
            }
            if(b.containsKey((Constants.KEY_BIO))) {
                bioView.setText(b.getString(Constants.KEY_BIO));
            }
        }

        textView.setText(msg);


    }


}
