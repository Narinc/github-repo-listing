package com.narinc.github_repo_listing.di.module.home;

import android.content.Context;

import androidx.room.Room;

import com.narinc.github_repo_listing.data.GithubApi;
import com.narinc.github_repo_listing.data.persistance.RepositoryDao;
import com.narinc.github_repo_listing.data.persistance.RepositoryDatabase;
import com.narinc.github_repo_listing.data.source.repositories.RepositoriesLocalDataSource;
import com.narinc.github_repo_listing.data.source.repositories.RepositoriesRemoteDataSource;
import com.narinc.github_repo_listing.data.source.repositories.RepositoriesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    RepositoryDatabase provideRepositoryDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                RepositoryDatabase.class, "Repository.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    RepositoryDao providesRepositoryDao(RepositoryDatabase database) {
        return database.repositoryDao();
    }


    @Provides
    GithubApi provideGithubApi(Retrofit retrofit) {
        return retrofit.create(GithubApi.class);
    }

    @Provides
    RepositoriesRemoteDataSource providesRemoteDataSource(GithubApi api) {
        return new RepositoriesRemoteDataSource(api);
    }

    @Provides
    RepositoriesLocalDataSource providesLocalDataSource(RepositoryDao dao) {
        return new RepositoriesLocalDataSource(dao);
    }

    @Provides
    RepositoriesRepository provideRepository(RepositoriesRemoteDataSource remoteDataSource,
                                             RepositoriesLocalDataSource localDataSource) {
        return new RepositoriesRepository(remoteDataSource, localDataSource);
    }
}
