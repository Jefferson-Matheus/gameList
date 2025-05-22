package com.matheusferreira.dbList.services;

import com.matheusferreira.dbList.dto.GameListDto;
import com.matheusferreira.dbList.entities.GameList;
import com.matheusferreira.dbList.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAllList(){
       List<GameList> gameListResult = gameListRepository.findAll();

       List<GameListDto> gameList = gameListResult.stream().map(x -> new GameListDto(x)).toList();

       return gameList;
    }
}
