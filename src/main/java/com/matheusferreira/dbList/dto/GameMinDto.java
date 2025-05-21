package com.matheusferreira.dbList.dto;

import com.matheusferreira.dbList.entities.Game;

public class GameMinDto {

    private Long id;
    private String title;
    private int year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDto() {
    }

    public GameMinDto(Game gameEntity) {
        this.id = gameEntity.getId();
        this.title = gameEntity.getTitle();
        this.year = gameEntity.getYear();
        this.imgUrl = gameEntity.getImgUrl();
        this.shortDescription = gameEntity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
