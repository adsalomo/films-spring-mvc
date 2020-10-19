package com.cuevana.controller;

import com.cuevana.model.Gender;
import com.cuevana.model.Movie;
import com.cuevana.service.iface.GenderService;
import com.cuevana.service.iface.MovieService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private GenderService genderService;

    @RequestMapping
    public String getMovies(Model model) {
        List<Movie> movies = movieService.getAll();
        model.addAttribute("movies", movies);
        return "index";
    }

    @RequestMapping(path = {"/create", "/edit/{id}"})
    public String editOrCreate(Model model, @PathVariable("id") Optional<Integer> id) {
        List<Gender> genders = genderService.getAll();
        model.addAttribute("genders", genders);

        if (id.isPresent()) {
            Movie movie = movieService.getMovieById(id.get());
            model.addAttribute("movie", movie);
        } else {
            Movie movie = new Movie();
            model.addAttribute("movie", movie);
        }
        return "add-edit-movie";
    }

    @RequestMapping(path = {"/create-movie"}, method = RequestMethod.POST)
    public String editOrCreate(Movie movie) {
        movieService.create(movie);
        return "redirect:/";
    }
}
