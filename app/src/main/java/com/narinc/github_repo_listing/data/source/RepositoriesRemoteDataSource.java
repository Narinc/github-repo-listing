package com.narinc.github_repo_listing.data.source;

import com.narinc.github_repo_listing.data.GithubApi;
import com.narinc.github_repo_listing.domain.model.Repository;

import java.util.List;

import javax.inject.Inject;

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
}
