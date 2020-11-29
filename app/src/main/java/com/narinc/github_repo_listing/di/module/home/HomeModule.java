package com.narinc.github_repo_listing.di.module.home;

import com.narinc.github_repo_listing.di.module.HomeVMModule;
import com.narinc.github_repo_listing.di.module.RepositoriesModule;

import dagger.Module;

@Module(includes = {RepositoriesModule.class, HomeVMModule.class})
public class HomeModule {
}
