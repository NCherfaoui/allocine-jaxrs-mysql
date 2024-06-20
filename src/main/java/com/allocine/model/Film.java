package com.allocine.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Lob
    private byte[] affiche;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    @ManyToMany
    @JoinTable(
            name = "acteur_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id")
    )
    private Set<Acteur> acteurs;

    // Getters and Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public byte[] getAffiche() {
        return affiche;
    }
    public void setAffiche(byte[] affiche) {
        this.affiche = affiche;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public Realisateur getRealisateur() {
        return realisateur;
    }
    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }
    public Set<Acteur> getActeurs() {
        return acteurs;
    }
    public void setActeurs(Set<Acteur> acteurs) {
        this.acteurs = acteurs;
    }
}