package com.matheusferreira.dbList.repositories;

import com.matheusferreira.dbList.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
