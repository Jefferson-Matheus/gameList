package com.matheusferreira.dbList.repositories;

import com.matheusferreira.dbList.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {
}
