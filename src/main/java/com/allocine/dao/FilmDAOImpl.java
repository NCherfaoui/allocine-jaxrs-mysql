package com.allocine.dao;

import com.allocine.dao.FilmDAO;
import com.allocine.model.Film;
import com.allocine.model.Acteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class FilmDAOImpl implements FilmDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("allocinePU");

    @Override
    public void save(Film film) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(film);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Film findById(int id) {
        EntityManager em = emf.createEntityManager();
        Film film = em.find(Film.class, id);
        em.close();
        return film;
    }

    @Override
    public List<Film> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Film> films = em.createQuery("from Film", Film.class).getResultList();
        em.close();
        return films;
    }

    @Override
    public void update(Film film) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(film);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Film film) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(film) ? film : em.merge(film));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void addActeurToFilm(int filmId, int acteurId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Film film = em.find(Film.class, filmId);
        Acteur acteur = em.find(Acteur.class, acteurId);
        film.getActeurs().add(acteur);
        em.merge(film);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeActeurFromFilm(int filmId, int acteurId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Film film = em.find(Film.class, filmId);
        Acteur acteur = em.find(Acteur.class, acteurId);
        film.getActeurs().remove(acteur);
        em.merge(film);
        em.getTransaction().commit();
        em.close();
    }
}