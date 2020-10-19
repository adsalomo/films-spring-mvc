package com.cuevana.repository;

import com.cuevana.model.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository de la entidad pelicula
 *
 * @author adrian
 */
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
