package com.example.testApp.Controller;



import com.example.testApp.Models.Film;
import com.example.testApp.Services.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/films")
    public List<Film> getAllFilms() {
        return rentalService.getAllFilms();
    }

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculatePrice(@RequestParam Long filmId, @RequestParam int days) {
        Film film = rentalService.getAllFilms().stream().filter(f -> f.getId().equals(filmId)).findFirst().orElse(null);
        if (film == null) {
            return ResponseEntity.badRequest().build();
        }
        double price = rentalService.calculateRentalPrice(film, days);
        return ResponseEntity.ok(price);
    }
}

