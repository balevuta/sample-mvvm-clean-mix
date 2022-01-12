package com.ethan.bridj.di

import com.ethan.bridj.data.network.EventsNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EventsProviderModule {

    @Provides
    @Singleton
    fun providesEventNetworkService(retrofit: Retrofit): EventsNetworkService {
        return retrofit.create(EventsNetworkService::class.java)
    }
}
