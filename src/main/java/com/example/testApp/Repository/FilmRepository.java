package com.example.testApp.Repository;




import com.example.testApp.Models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}

