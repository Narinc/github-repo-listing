package com.narinc.github_repo_listing.ui.home;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.narinc.github_repo_listing.domain.GetRepositories;
import com.narinc.github_repo_listing.domain.model.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class HomeViewModel extends ViewModel {

    @Inject
    GetRepositories getRepositoriesUseCase;

    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ObservableField<String> login = new ObservableField<>();
    private final MutableLiveData<List<Repository>> repositories = new MutableLiveData<>();

    @Inject
    public HomeViewModel() {

    }

    public ObservableField<String> getLogin() {
        return login;
    }

    public LiveData<List<Repository>> getRepositories() {
        return repositories;
    }

    public void getExams() {
        Disposable disposable = getRepositoriesUseCase.loadByLogin(login.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repositories::setValue, this::onError);
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
