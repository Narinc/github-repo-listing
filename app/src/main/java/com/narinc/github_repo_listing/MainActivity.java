package com.narinc.github_repo_listing;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.host);

    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return true;
    }
}
