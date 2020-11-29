package com.narinc.github_repo_listing.data;

import com.narinc.github_repo_listing.domain.model.Repository;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {
    @GET("users/{login}/repos")
    Observable<List<Repository>> getRepositoriesByLogin(@Path("login") String login);
}
