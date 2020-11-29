package com.narinc.github_repo_listing.di.module;

import androidx.lifecycle.ViewModel;

import com.narinc.github_repo_listing.di.util.ViewModelKey;
import com.narinc.github_repo_listing.ui.home.HomeViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface HomeVMModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    ViewModel bindsHomeViewModel(HomeViewModel viewModel);
}
