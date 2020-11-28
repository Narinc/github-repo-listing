package com.narinc.github_repo_listing.di.module;

import com.narinc.github_repo_listing.ui.login.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Provide fragment injectors of MainActivity
 */
@Module
public interface MainActivityBuilderModule {
    @ContributesAndroidInjector
    LoginFragment provideLoginFragment();

}