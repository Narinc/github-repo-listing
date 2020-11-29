package com.narinc.github_repo_listing.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.narinc.github_repo_listing.databinding.FragmentDetailBinding;
import com.narinc.github_repo_listing.domain.model.Repository;

import dagger.android.support.DaggerFragment;

public class DetailFragment extends DaggerFragment {

    private Repository getRepository() {
        if (getArguments() != null) {
            return DetailFragmentArgs.fromBundle(getArguments()).getStringRepository();
        } else return null;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDetailBinding binding = FragmentDetailBinding.inflate(inflater, container, false);
        binding.setData(getRepository());
        return binding.getRoot();
    }

}
