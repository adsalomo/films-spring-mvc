package com.cuevana.repository;

import com.cuevana.model.Gender;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository genero peliculas
 * Spring Data es un proyecto de SpringSource cuyo propósito es unificar y facilitar el acceso 
 * a distintos tipos de tecnologías de persistencia, tanto a bases de datos relacionales 
 * como a las del tipo NoSQL.
 * @author adrian
 */
public interface GenderRepository extends CrudRepository<Gender, Integer> {

}
