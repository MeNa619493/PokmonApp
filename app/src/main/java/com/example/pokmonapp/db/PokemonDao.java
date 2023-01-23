package com.example.pokmonapp.db;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pokmonapp.model.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {
    @Insert(onConflict = REPLACE)
    public void insertPokemon(Pokemon pokemon);

    @Query("DELETE FROM fav_table WHERE name =:pokemonName")
    public void deletePokemon(String pokemonName);

    @Query("SELECT * FROM fav_table")
    public LiveData<List<Pokemon>> getPokemon();
}
