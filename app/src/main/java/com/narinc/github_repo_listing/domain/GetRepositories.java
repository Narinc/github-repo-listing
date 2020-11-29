package com.narinc.github_repo_listing.domain;

import com.narinc.github_repo_listing.data.source.RepositoriesRepository;
import com.narinc.github_repo_listing.domain.model.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetRepositories {

    @Inject
    RepositoriesRepository repository;

    @Inject
    public GetRepositories() {

    }

    public Observable<List<Repository>> loadByLogin(String login) {
        return repository.loadByLogin(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
