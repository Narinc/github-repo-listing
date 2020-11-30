package com.narinc.github_repo_listing.ui.home;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.narinc.github_repo_listing.domain.FavoritesUseCase;
import com.narinc.github_repo_listing.domain.GetRepositories;
import com.narinc.github_repo_listing.data.persistance.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class HomeViewModel extends ViewModel {

    @Inject
    GetRepositories getRepositoriesUseCase;

    @Inject
    FavoritesUseCase favoritesUseCase;

    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ObservableField<String> login = new ObservableField<>();
    private final MutableLiveData<List<Repository>> repositories = new MutableLiveData<>();
    private final List<Repository> savedRepositories = new ArrayList<>();

    @Inject
    public HomeViewModel(FavoritesUseCase favoritesUseCase) {
        this.favoritesUseCase = favoritesUseCase;
        loadFavorites();
    }

    public ObservableField<String> getLogin() {
        return login;
    }

    public LiveData<List<Repository>> getRepositories() {
        return repositories;
    }

    public void loadFavorites() {
        Disposable disposable = favoritesUseCase.getFavorites()
                .subscribe(savedRepositories::addAll, this::onError);
        disposables.add(disposable);
    }

    public void loadRepositoriesByLogin() {
        Disposable disposable = getRepositoriesUseCase.loadByLogin(login.get())
                .subscribe(this::onSubscribedRepositories, this::onError);
        disposables.add(disposable);
    }

    private void onSubscribedRepositories(@NonNull List<Repository> repositoriesByLogin) {
        if (savedRepositories.size() > 0) {
            for (Repository repository : repositoriesByLogin) {
                if (savedRepositories.contains(repository)) {
                    repository.setFavorite(true);
                }
            }
        }
        repositories.setValue(repositoriesByLogin);
    }

    private void onError(Throwable throwable) {
        Timber.e(throwable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
