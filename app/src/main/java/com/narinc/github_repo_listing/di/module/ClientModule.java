package com.narinc.github_repo_listing.di.module;

import dagger.Module;

@Module
public class ClientModule {
    /*
    *  @Provides
    ReservationApi provideReservationApi(Retrofit retrofit) {
        return retrofit.create(ReservationApi.class);
    }

    @Provides
    ReservationRemoteDataSource providesRemoteDataSource(ReservationApi service) {
        return new ReservationRemoteDataSource(service);
    }

    @Provides
    @Reusable
    ReservationRepository provideRepository(ReservationRemoteDataSource remoteDataSource) {
        return new ReservationRepository(remoteDataSource);
    }*/
}
