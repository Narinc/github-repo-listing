package com.narinc.github_repo_listing.ui.detail;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.narinc.github_repo_listing.data.persistance.Repository;
import com.narinc.github_repo_listing.domain.FavoritesUseCase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class DetailViewModel extends ViewModel {

    @Inject
    FavoritesUseCase favoritesUseCase;

    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ObservableField<Repository> repository = new ObservableField<>();
    public final ObservableBoolean fav = new ObservableBoolean();

    @Inject
    public DetailViewModel() {
    }

    public ObservableField<Repository> getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository.set(repository);
        fav.set(repository.isFavorite());
        fav.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                repository.setFavorite(fav.get());
            }
        });
    }

    public void toggle(Repository repository){
        if (repository.isFavorite()) {
            removeFavorite(repository);
        } else insertFavorite(repository);
    }

    public void insertFavorite(Repository repository) {
        Disposable disposable = favoritesUseCase.insert(repository)
                .subscribe(() -> fav.set(true), this::onError);
        disposables.add(disposable);
    }

    public void removeFavorite(Repository repository) {
        Disposable disposable = favoritesUseCase.remove(repository)
                .subscribe(() -> fav.set(false), this::onError);
        disposables.add(disposable);
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
