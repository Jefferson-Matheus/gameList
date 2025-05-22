package com.matheusferreira.dbList.services;

import com.matheusferreira.dbList.dto.GameDto;
import com.matheusferreira.dbList.dto.GameMinDto;
import com.matheusferreira.dbList.entities.Game;
import com.matheusferreira.dbList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> gamesResult = gameRepository.findAll();

        List<GameMinDto> gameMinimalInformations = gamesResult.stream().map(x -> new GameMinDto(x)).toList();

        return  gameMinimalInformations;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        Game singleGameResult = gameRepository.findById(id).get();

        GameDto gameDto = new GameDto(singleGameResult);

        return gameDto;
    }
}
