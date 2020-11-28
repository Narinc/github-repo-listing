package com.narinc.github_repo_listing.di.module;

import com.narinc.github_repo_listing.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilderModule {
    @ContributesAndroidInjector(modules = {MainActivityBuilderModule.class})
    MainActivity bindMainActivity();
}


