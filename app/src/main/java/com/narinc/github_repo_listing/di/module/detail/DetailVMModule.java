package com.narinc.github_repo_listing.di.module.detail;

import androidx.lifecycle.ViewModel;

import com.narinc.github_repo_listing.di.util.ViewModelKey;
import com.narinc.github_repo_listing.ui.detail.DetailViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface DetailVMModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel.class)
    ViewModel bindsDetailViewModel(DetailViewModel viewModel);
}
