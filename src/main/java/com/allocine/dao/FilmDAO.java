package com.allocine.dao;

import com.allocine.model.Film;
import java.util.List;

public interface FilmDAO {
    void save(Film film);
    Film findById(int id);
    List<Film> findAll();
    void update(Film film);
    void delete(Film film);
    void addActeurToFilm(int filmId, int acteurId);
    void removeActeurFromFilm(int filmId, int acteurId);
}