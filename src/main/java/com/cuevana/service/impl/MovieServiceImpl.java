package com.cuevana.service.impl;

import com.cuevana.dto.MovieDto;
import com.cuevana.model.Gender;
import com.cuevana.model.Movie;
import com.cuevana.repository.GenderRepository;
import com.cuevana.repository.MovieRepository;
import com.cuevana.service.iface.MovieService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion de la interface MovieService
 *
 * @author adrian
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();
        this.movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    @Override
    public void create(Movie movie) {
        Optional<Gender> existsGender = this.genderRepository.findById(movie.getGenderId().getId());
        if (existsGender.isPresent()) {
            movie.setCreatedAt(LocalDateTime.now());
            movie.setGenderId(existsGender.get());
            this.movieRepository.save(movie);
        }
    }

    @Override
    public void edit(Movie movie, int movieId) {
        Optional<Movie> existsMovie = this.movieRepository.findById(movieId);
        if (existsMovie.isPresent()) {
            existsMovie.get().setName(movie.getName());
            existsMovie.get().setDescription(movie.getDescription());
            existsMovie.get().setActors(movie.getActors());
            existsMovie.get().setImage(movie.getImage());
            existsMovie.get().setRating(movie.getRating());
            existsMovie.get().setReleaseDate(movie.getReleaseDate());
            Optional<Gender> existsGender = this.genderRepository.findById(movie.getGenderId().getId());
            if (existsGender.isPresent()) {
                existsMovie.get().setGenderId(existsGender.get());
            }
            this.movieRepository.save(existsMovie.get());
        }
    }

    @Override
    public void delete(int movieId) {
        Optional<Movie> existsMovie = this.movieRepository.findById(movieId);
        if (existsMovie.isPresent()) {
            this.movieRepository.delete(existsMovie.get());
        }
    }

    @Override
    public void rate(Movie movie, int movieId) {
        Optional<Movie> existsMovie = this.movieRepository.findById(movieId);
        if (existsMovie.isPresent()) {
            existsMovie.get().setRating(existsMovie.get().getRating() + movie.getRating());
            this.movieRepository.save(existsMovie.get());
        }
    }

    @Override
    public Movie getMovieById(int id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            return new Movie();
        } else {
            return movie.get();
        }
    }

    @Override
    public void create(MovieDto movieDto) throws Exception {
        Optional<Gender> existsGender = this.genderRepository
                .findById(movieDto.getGenderId());
        if (!existsGender.isPresent()) {
            throw new Exception("Genero no existe");
        }
        
        Movie movie = new Movie();
        movie.setName(movieDto.getName());
        movie.setDescription(movieDto.getDescription());
        movie.setImage(movieDto.getImage());
        movie.setActors(movieDto.getActors());
        movie.setRating(movieDto.getRating());
        movie.setGenderId(existsGender.get());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setCreatedAt(LocalDateTime.now());
        this.movieRepository.save(movie);
    }

    @Override
    public List<MovieDto> findAll() throws Exception {
        List<Movie> movies = new ArrayList<>();
        this.movieRepository.findAll().forEach(movies::add);
        if (movies.isEmpty()) {
            throw new Exception("No existe informacion");
        }
        
        List<MovieDto> moviesDtos = new ArrayList<>();
        
        for (Movie movie : movies) {
            MovieDto movieDto = new MovieDto();
            movieDto.setId(movie.getId());
            movieDto.setName(movie.getName());
            movieDto.setDescription(movie.getDescription());
            movieDto.setImage(movie.getImage());
            movieDto.setActors(movie.getActors());
            movieDto.setReleaseDate(movie.getReleaseDate());
            movieDto.setRating(movie.getRating());
            movieDto.setGenderId(movie.getGenderId().getId());
            movieDto.setGenderName(movie.getGenderId().getName());
            moviesDtos.add(movieDto);
        }
        
        return moviesDtos;
    }

}
