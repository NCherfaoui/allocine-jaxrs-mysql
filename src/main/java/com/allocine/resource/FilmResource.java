package com.allocine.resource;

import com.allocine.dao.FilmDAO;
import com.allocine.dao.FilmDAOImpl;
import com.allocine.model.Film;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/films")
public class FilmResource {
    private FilmDAO filmDAO = new FilmDAOImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getAllFilms() {
        return filmDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film getFilmById(@PathParam("id") int id) {
        return filmDAO.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFilm(Film film) {
        filmDAO.save(film);
        return Response.status(Response.Status.CREATED).entity(film).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFilm(@PathParam("id") int id, Film film) {
        Film existingFilm = filmDAO.findById(id);
        if (existingFilm == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        film.setId(id);
        filmDAO.update(film);
        return Response.ok(film).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFilm(@PathParam("id") int id) {
        Film film = filmDAO.findById(id);
        if (film == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        filmDAO.delete(film);
        return Response.noContent().build();
    }
}