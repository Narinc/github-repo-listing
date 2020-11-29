package com.narinc.github_repo_listing.data.source;

import com.narinc.github_repo_listing.domain.model.Repository;

import java.util.List;

import io.reactivex.Observable;

public interface RepositoriesDataSource {
    Observable<List<Repository>> loadByLogin(String login);
}
