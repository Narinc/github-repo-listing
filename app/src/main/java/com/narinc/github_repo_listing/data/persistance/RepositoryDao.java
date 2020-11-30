package com.narinc.github_repo_listing.data.persistance;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface RepositoryDao {
    @Query("SELECT * FROM Repositories")
    Observable<List<Repository>> getFavorites();

    @Delete
    Completable remove(Repository... repository);

    @Insert
    Completable insert(Repository... repository);
}
