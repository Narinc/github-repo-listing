package com.narinc.github_repo_listing.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.narinc.github_repo_listing.databinding.FragmentHomeBinding;
import com.narinc.github_repo_listing.domain.model.Repository;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class HomeFragment extends DaggerFragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        HomeViewModel vm = new ViewModelProvider(requireActivity(), viewModelFactory).get(HomeViewModel.class);
        vm.getRepositories().observe(getViewLifecycleOwner(), this::showRepositories);
        binding.setVm(vm);

        return binding.getRoot();
    }

    private void showRepositories(List<Repository> repositories) {
        if (binding.repositories.getAdapter() instanceof RepositoryAdapter) {
            ((RepositoryAdapter) binding.repositories.getAdapter()).submitList(repositories);
        } else {
            RepositoryAdapter adapter = new RepositoryAdapter(this::navigateDetail);
            binding.repositories.setAdapter(adapter);
            adapter.submitList(repositories);
        }
    }

    private void navigateDetail(Repository repository) {
        NavHostFragment.findNavController(this)
                .navigate(HomeFragmentDirections.actionLoginFragmentToDetailFragment(repository));
    }

}
