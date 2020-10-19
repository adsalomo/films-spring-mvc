package com.cuevana.service.iface;

import com.cuevana.model.Movie;
import java.util.List;

/**
 * Interface para declarar los metodos relacionados a la entidad movie
 * @author adrian
 */
public interface MovieService {
    
    /**
     * Obtiene todas las peliculas
     * @return  Lista de peliculas
     */
    List<Movie> getAll();
    
    /**
     * Crea nueva pelicula
     * @param movie Objeto Movie
     */
    void create(Movie movie);
    
    /**
     * Edita una pelicula
     * @param movie Objeto Movie
     * @param movieId int movieId
     */
    void edit(Movie movie, int movieId);
    
    /**
     * Elimina una pelicula
     * @param movie Objeto Movie
     * @param movieId int movieId
     */
    void delete(int movieId);
    
    /**
     * Califica una pelicula
     * @param movie Objeto Movie
     * @param movieId int movieId
     */
    void rate(Movie movie, int movieId);
    
    Movie getMovieById(int id);
}
