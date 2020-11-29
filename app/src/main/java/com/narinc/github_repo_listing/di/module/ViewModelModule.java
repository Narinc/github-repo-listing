package com.narinc.github_repo_listing.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.narinc.github_repo_listing.di.util.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

/**
 * Provide viewModel factory and injectors
 */
@Module
public interface ViewModelModule {
    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
