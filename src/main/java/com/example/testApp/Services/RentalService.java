package com.example.testApp.Services;


import com.example.testApp.Models.Film;
import com.example.testApp.Repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    private final FilmRepository filmRepository;

    public RentalService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public double calculateRentalPrice(Film film, int days) {
        double price = 0;
        switch (film.getType()) {
            case "NEW":
                price = days * 40;
                break;
            case "REGULAR":
                price = (days <= 3) ? 30 : (30 + (days - 3) * 30);
                break;
            case "OLD":
                price = (days <= 5) ? 30 : (30 + (days - 5) * 30);
                break;
        }
        return price;
    }
}

