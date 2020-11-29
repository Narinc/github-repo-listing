package com.narinc.github_repo_listing.di.module;

import com.narinc.github_repo_listing.ui.home.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Provide fragment injectors of MainActivity
 */
@Module
public interface MainActivityBuilderModule {
    @ContributesAndroidInjector
    HomeFragment provideHomeFragment();
}