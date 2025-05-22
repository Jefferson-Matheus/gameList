package com.matheusferreira.dbList.dto;

import com.matheusferreira.dbList.entities.GameList;

public class GameListDto {

    private Long id;

    private String name;

    public GameListDto() {
    }

    public GameListDto(GameList gameListEntity) {
        id = gameListEntity.getId();
        name = gameListEntity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
