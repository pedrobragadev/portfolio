package com.rent.starmovies.repositories;

import com.rent.starmovies.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoy extends JpaRepository<Client, Long> {
}
