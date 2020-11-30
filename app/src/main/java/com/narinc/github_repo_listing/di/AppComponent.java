package com.narinc.github_repo_listing.di;

import android.app.Application;

import com.narinc.github_repo_listing.BaseApplication;
import com.narinc.github_repo_listing.di.module.ActivityBuilderModule;
import com.narinc.github_repo_listing.di.module.AppModule;
import com.narinc.github_repo_listing.di.module.ContextModule;
import com.narinc.github_repo_listing.di.module.ViewModelModule;
import com.narinc.github_repo_listing.di.module.detail.DetailVMModule;
import com.narinc.github_repo_listing.di.module.home.HomeModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {ContextModule.class,
        AppModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        ViewModelModule.class,
        HomeModule.class,
        DetailVMModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}