package com.narinc.github_repo_listing.data.source;

import com.narinc.github_repo_listing.domain.model.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RepositoriesRepository implements RepositoriesDataSource {

    private final RepositoriesRemoteDataSource remoteDataSource;

    @Inject
    public RepositoriesRepository(RepositoriesRemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Repository>> loadByLogin(String login) {
        return remoteDataSource.loadByLogin(login);
    }
}

