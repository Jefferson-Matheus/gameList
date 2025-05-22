package com.matheusferreira.dbList.controllers;

import com.matheusferreira.dbList.dto.GameDto;
import com.matheusferreira.dbList.dto.GameMinDto;
import com.matheusferreira.dbList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDto> findAll(){
        List<GameMinDto> gamesResult = gameService.findAll();

        return gamesResult;
    }

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable Long id){
        GameDto result = gameService.findById(id);

        return result;
    }
}
