package com.rent.starmovies.repositories;

import com.rent.starmovies.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
