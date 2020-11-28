package com.narinc.github_repo_listing.ui.login;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narinc.github_repo_listing.R;

import dagger.android.support.DaggerFragment;

public class LoginFragment extends DaggerFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

}
