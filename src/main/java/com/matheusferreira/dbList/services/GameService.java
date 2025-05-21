package com.matheusferreira.dbList.services;

import com.matheusferreira.dbList.dto.GameMinDto;
import com.matheusferreira.dbList.entities.Game;
import com.matheusferreira.dbList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){
        List<Game> gamesResult = gameRepository.findAll();

        List<GameMinDto> gameMinimalInformations = gamesResult.stream().map(x -> new GameMinDto(x)).toList();

        return  gameMinimalInformations;
    }
}
