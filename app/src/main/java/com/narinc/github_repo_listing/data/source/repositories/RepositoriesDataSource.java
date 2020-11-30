package com.narinc.github_repo_listing.data.source.repositories;

import com.narinc.github_repo_listing.data.persistance.Repository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface RepositoriesDataSource {
    Observable<List<Repository>> loadByLogin(String login);

    Observable<List<Repository>> getFavorites();

    Completable insert(Repository favorite);

    Completable remove(Repository favorite);
}
