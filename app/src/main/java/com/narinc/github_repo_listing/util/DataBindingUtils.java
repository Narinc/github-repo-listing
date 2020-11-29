package com.narinc.github_repo_listing.util;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class DataBindingUtils {
    @BindingAdapter("avatar")
    public static void show(@NonNull ImageView view, @Nullable String url) {
        Glide.with(view)
                .load(url)
                .into(view);
    }
}
