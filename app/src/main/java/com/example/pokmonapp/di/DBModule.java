package com.example.pokmonapp.di;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pokmonapp.db.PokemonDB;
import com.example.pokmonapp.db.PokemonDao;
import com.example.pokmonapp.network.PokemonApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class DBModule {

    @Singleton
    @Provides
    public static PokemonDB provideDB(Application application) {
        return Room.databaseBuilder(application, PokemonDB.class, "fav_DB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static PokemonDao provideDao(PokemonDB pokemonDB){
        return pokemonDB.pokemonDao();
    }

}
