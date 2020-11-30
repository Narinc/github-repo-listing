package com.narinc.github_repo_listing.util;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class DataBindingUtils {
    @BindingAdapter("avatar")
    public static void avatar(@NonNull ImageView view, @Nullable String url) {
        Glide.with(view)
                .load(url)
                .into(view);
    }

    @BindingAdapter("visibility")
    public static void visibility(@NonNull View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
}
