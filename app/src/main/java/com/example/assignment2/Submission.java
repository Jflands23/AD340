package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

;

public class Submission extends AppCompatActivity{
    private FragmentManager manager;
    private String uname;
    private String bio;
    private String name;
    private String job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submission);

        manager = getSupportFragmentManager();
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            if (b.containsKey(Constants.KEY_USER)) {
                uname = b.getString(Constants.KEY_USER);
            }
            if (b.containsKey((Constants.KEY_BIO))) {
                bio = b.getString(Constants.KEY_BIO);
            }
            if (b.containsKey((Constants.KEY_NAME))) {
                name = b.getString(Constants.KEY_NAME);
            }
            if (b.containsKey((Constants.KEY_JOB))) {
                job = b.getString(Constants.KEY_JOB);
            }
        }

        ProfileFragment fragment = new ProfileFragment();
        fragment.setAttachment(new Attachment(uname, bio, name, job));

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment, "fragA");
        transaction.commit();

    }
    public static class Attachment {
        String uname;
        String bio;
        String name;
        String job;

        Attachment(String uname, String bio, String name, String job) {
            this.uname = uname;
            this.name = name;
            this.bio = bio;
            this.job = job;
        }
    }

}
