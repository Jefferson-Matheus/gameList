package com.matheusferreira.dbList.services;

import com.matheusferreira.dbList.dto.GameListDto;
import com.matheusferreira.dbList.entities.GameList;
import com.matheusferreira.dbList.projections.GameMinProjection;
import com.matheusferreira.dbList.repositories.GameListRepository;
import com.matheusferreira.dbList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAllList(){
       List<GameList> gameListResult = gameListRepository.findAll();

       List<GameListDto> gameList = gameListResult.stream().map(x -> new GameListDto(x)).toList();

       return gameList;
    }

    @Transactional
    public void replaceGamesONList(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> listOfGamesBycategory = gameRepository.searchByList(listId);
        GameMinProjection objectRemoved = listOfGamesBycategory.remove(sourceIndex);
        listOfGamesBycategory.add(destinationIndex, objectRemoved);
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, listOfGamesBycategory.get(i).getId(), i);
        }
    }
}
