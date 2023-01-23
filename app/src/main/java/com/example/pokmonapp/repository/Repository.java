package com.example.pokmonapp.repository;

import androidx.lifecycle.LiveData;

import com.example.pokmonapp.db.PokemonDao;
import com.example.pokmonapp.model.Pokemon;
import com.example.pokmonapp.model.PokemonResponse;
import com.example.pokmonapp.network.PokemonApiService;

import java.util.List;

import javax.inject.Inject;
import io.reactivex.rxjava3.core.Observable;


public class Repository {
    private PokemonApiService pokemonApiService;
    private PokemonDao pokemonDao;

    @Inject
    public Repository(PokemonApiService pokemonApiService, PokemonDao pokemonDao) {
        this.pokemonApiService = pokemonApiService;
        this.pokemonDao = pokemonDao;
    }

    public Observable<PokemonResponse> getPokemon() {
        return pokemonApiService.getPokemon();
    }

    public void insertPokemon(Pokemon pokemon) {
        pokemonDao.insertPokemon(pokemon);
    }

    public void deletePokemon(String pokemonName) {
        pokemonDao.deletePokemon(pokemonName);
    }

    public LiveData<List<Pokemon>> getFavoritePokemon() {
        return pokemonDao.getPokemon();
    }

}
