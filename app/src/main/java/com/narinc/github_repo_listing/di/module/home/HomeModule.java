package com.narinc.github_repo_listing.di.module.home;

import dagger.Module;

@Module(includes = {RepositoriesModule.class, HomeVMModule.class})
public class HomeModule {
}
