package com.rent.starmovies.repositories;

import com.rent.starmovies.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
