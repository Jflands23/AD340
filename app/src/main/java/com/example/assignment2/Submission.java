package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.example.assignment2.model.Match;
import com.example.assignment2.viewmodels.MatchesViewModel;

public class Submission extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,MyListener {
    private FragmentManager manager;
    private String uname;
    private String bio;
    private String name;
    private String job;
    TextView textView;
    TextView bioView;
    TextView nameView;
    TextView jobView;
    DatePicker dob;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private MatchesViewModel viewModel;
    Toolbar toolbar;
    Menu menu;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submission);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        /* textView2=findViewById(R.id.textView); */
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewModel = new MatchesViewModel();

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        /*navigationView.setCheckedItem(R.id.nav_home);*/

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

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_profile:
                ProfileFragment fragment = new ProfileFragment();
                fragment.setAttachment(new Attachment(uname, bio, name, job));

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragment).commit();
                break;
            case R.id.nav_matches:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new MatchesFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    public void matchesLikeToast(Match m) {
        if(!m.liked) {
            Toast.makeText(this, String.format("You Liked " + m.name), Toast.LENGTH_SHORT).show();
            m.liked = true;
        } else {
            m.liked = false;
        }
        viewModel.updateMatch(m);
    }
    @Override
    protected void onPause() {
        viewModel.clear();
        super.onPause();
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
