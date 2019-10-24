package com.narinc.socket_example.di.module;

import com.narinc.socket_example.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilderModule {
    @ContributesAndroidInjector(modules = {MainActivityBuilderModule.class})
    MainActivity bindMainActivity();
}


