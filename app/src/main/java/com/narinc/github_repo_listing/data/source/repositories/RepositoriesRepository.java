package com.narinc.github_repo_listing.data.source.repositories;

import com.narinc.github_repo_listing.data.persistance.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class RepositoriesRepository implements RepositoriesDataSource {

    private final RepositoriesRemoteDataSource remoteDataSource;
    private final RepositoriesLocalDataSource localDataSource;

    @Inject
    public RepositoriesRepository(RepositoriesRemoteDataSource remoteDataSource,
                                  RepositoriesLocalDataSource localDataSource){
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Observable<List<Repository>> loadByLogin(String login) {
        return remoteDataSource.loadByLogin(login);
    }

    @Override
    public Observable<List<Repository>> getFavorites() {
        return localDataSource.getFavorites();
    }

    @Override
    public Completable insert(Repository favorite) {
        return localDataSource.insert(favorite);
    }

    @Override
    public Completable remove(Repository favorite) {
        return localDataSource.remove(favorite);
    }
}

