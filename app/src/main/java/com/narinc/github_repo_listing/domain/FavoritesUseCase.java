package com.narinc.github_repo_listing.domain;

import com.narinc.github_repo_listing.data.source.repositories.RepositoriesRepository;
import com.narinc.github_repo_listing.data.persistance.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FavoritesUseCase {

    @Inject
    RepositoriesRepository repository;

    @Inject
    public FavoritesUseCase() {

    }

    public Observable<List<Repository>> getFavorites() {
        return repository.getFavorites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable insert(Repository repository) {
        return this.repository.insert(repository)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());    }

    public Completable remove(Repository repository) {
        return this.repository.remove(repository)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());    }
}
