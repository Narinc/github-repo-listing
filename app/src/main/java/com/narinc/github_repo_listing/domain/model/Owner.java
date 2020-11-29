package com.narinc.github_repo_listing.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Owner implements Parcelable {
    @SerializedName("login")
    private int login;
    @SerializedName("avatar_url")
    private int avatarUrl;

    protected Owner(Parcel in) {
        login = in.readInt();
        avatarUrl = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(login);
        dest.writeInt(avatarUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public int getLogin() {
        return login;
    }

    public int getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return login == owner.login;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
