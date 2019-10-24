package com.narinc.socket_example.di.module;

import com.narinc.socket_example.ui.login.LoginFragment;

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