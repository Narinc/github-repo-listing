package com.narinc.github_repo_listing.data.source.repositories;

import com.narinc.github_repo_listing.data.GithubApi;
import com.narinc.github_repo_listing.data.persistance.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class RepositoriesRemoteDataSource implements RepositoriesDataSource {

    private final GithubApi api;

    @Inject
    public RepositoriesRemoteDataSource(GithubApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<Repository>> loadByLogin(String login) {
        return api.getRepositoriesByLogin(login);
    }

    @Override
    public Observable<List<Repository>> getFavorites() {
        return Observable.never();
    }

    @Override
    public Completable insert(Repository favorite) {
        return Completable.never();
    }

    @Override
    public Completable remove(Repository favorite) {
        return Completable.never();
    }
}
