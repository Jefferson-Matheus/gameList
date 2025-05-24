package com.matheusferreira.dbList.controllers;

import com.matheusferreira.dbList.dto.GameDto;
import com.matheusferreira.dbList.dto.GameListDto;
import com.matheusferreira.dbList.dto.GameMinDto;
import com.matheusferreira.dbList.dto.ReplacementDto;
import com.matheusferreira.dbList.services.GameListService;
import com.matheusferreira.dbList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll(){
        List<GameListDto> gameListResult = gameListService.findAllList();

        return gameListResult;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findById(@PathVariable Long listId){
        List<GameMinDto> result = gameService.findByList(listId);

        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDto body) {
        gameListService.replaceGamesONList(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}

