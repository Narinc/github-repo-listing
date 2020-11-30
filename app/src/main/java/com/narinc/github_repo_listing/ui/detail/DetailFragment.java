package com.narinc.github_repo_listing.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.narinc.github_repo_listing.databinding.FragmentDetailBinding;
import com.narinc.github_repo_listing.data.persistance.Repository;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class DetailFragment extends DaggerFragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private DetailViewModel viewModel;

    private Repository getRepository() {
        if (getArguments() != null) {
            return DetailFragmentArgs.fromBundle(getArguments()).getStringRepository();
        } else return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this, viewModelFactory).get(DetailViewModel.class);
        viewModel.setRepository(getRepository());
        FragmentDetailBinding binding = FragmentDetailBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.toolbar);
        binding.setVm(viewModel);
        return binding.getRoot();
    }

}
