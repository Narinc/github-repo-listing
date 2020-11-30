package com.narinc.github_repo_listing.data.persistance;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Converters {
    @TypeConverter
    public static Owner getOwner(String owner) {
        return new Gson().fromJson(owner, new TypeToken<Owner>() {
        }.getType());
    }

    @TypeConverter
    public static String saveOwner(Owner owner) {
        return new Gson().toJson(owner);
    }
}
