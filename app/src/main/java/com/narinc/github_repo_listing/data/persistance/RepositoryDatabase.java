package com.narinc.github_repo_listing.data.persistance;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Repository.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class RepositoryDatabase extends RoomDatabase {
    public abstract RepositoryDao repositoryDao();
}
