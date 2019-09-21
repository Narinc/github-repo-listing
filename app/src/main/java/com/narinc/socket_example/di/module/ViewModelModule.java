package com.narinc.socket_example.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.narinc.socket_example.di.util.ViewModelFactory;

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
