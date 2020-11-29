package com.narinc.github_repo_listing.di.module;

import com.narinc.github_repo_listing.data.GithubApi;
import com.narinc.github_repo_listing.data.source.RepositoriesRemoteDataSource;
import com.narinc.github_repo_listing.data.source.RepositoriesRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepositoriesModule {
    @Provides
    GithubApi provideGithubApi(Retrofit retrofit) {
        return retrofit.create(GithubApi.class);
    }

    @Provides
    RepositoriesRemoteDataSource providesRemoteDataSource(GithubApi api) {
        return new RepositoriesRemoteDataSource(api);
    }

    @Provides
    RepositoriesRepository provideRepository(RepositoriesRemoteDataSource remoteDataSource) {
        return new RepositoriesRepository(remoteDataSource);
    }
}
