package com.narinc.github_repo_listing.data.source.repositories;

import com.narinc.github_repo_listing.data.persistance.RepositoryDao;
import com.narinc.github_repo_listing.data.persistance.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class RepositoriesLocalDataSource implements RepositoriesDataSource {

    private final RepositoryDao dao;

    @Inject
    public RepositoriesLocalDataSource(RepositoryDao dao) {
        this.dao = dao;
    }

    @Override
    public Observable<List<Repository>> loadByLogin(String login) {
        return Observable.never();
    }

    @Override
    public Observable<List<Repository>> getFavorites() {
        return dao.getFavorites();
    }

    @Override
    public Completable insert(Repository favorite) {
        return dao.insert(favorite);
    }

    @Override
    public Completable remove(Repository favorite) {
        return dao.remove(favorite);
    }

}
