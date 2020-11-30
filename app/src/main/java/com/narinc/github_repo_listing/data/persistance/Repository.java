package com.narinc.github_repo_listing.data.persistance;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity(tableName = "Repositories")
public class Repository implements Parcelable {
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("stargazers_count")
    @Expose
    private String stargazersCount;
    @SerializedName("open_issues_count")
    @Expose
    private String openIssuesCount;
    @SerializedName("owner")
    @Expose
    private Owner owner;

    private boolean favorite;

    @Ignore
    public Repository() {
    }

    public Repository(int id, String name, String stargazersCount, String openIssuesCount, Owner owner, boolean favorite) {
        this.id = id;
        this.name = name;
        this.stargazersCount = stargazersCount;
        this.openIssuesCount = openIssuesCount;
        this.owner = owner;
        this.favorite = favorite;
    }

    @Ignore
    protected Repository(Parcel in) {
        id = in.readInt();
        name = in.readString();
        stargazersCount = in.readString();
        openIssuesCount = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(stargazersCount);
        dest.writeString(openIssuesCount);
        dest.writeParcelable(owner, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStargazersCount() {
        return stargazersCount;
    }

    public String getOpenIssuesCount() {
        return openIssuesCount;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static DiffUtil.ItemCallback<Repository> DIFF_CALLBACK = new DiffUtil.ItemCallback<Repository>() {

        @Override
        public boolean areItemsTheSame(@NonNull Repository oldItem, @NonNull Repository newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Repository oldItem, @NonNull Repository newItem) {
            return oldItem.equals(newItem);
        }
    };

}
