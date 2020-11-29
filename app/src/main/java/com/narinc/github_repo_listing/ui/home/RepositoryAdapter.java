package com.narinc.github_repo_listing.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.narinc.github_repo_listing.databinding.ItemRepositoryBinding;
import com.narinc.github_repo_listing.domain.model.Repository;

public class RepositoryAdapter extends ListAdapter<Repository, RepositoryAdapter.ViewHolder> {

    RepositoryAdapter() {
        super(Repository.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRepositoryBinding binding = ItemRepositoryBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemRepositoryBinding binding;

        ViewHolder(@NonNull ItemRepositoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void onBind(Repository data) {
            binding.setData(data);
            binding.executePendingBindings();
        }
    }
}
