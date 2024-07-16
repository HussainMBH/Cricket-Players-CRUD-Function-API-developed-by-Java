package com.dailycodebuffer.cricket.service;

import com.dailycodebuffer.cricket.entity.PlayerEntity;
import com.dailycodebuffer.cricket.exception.CricketAppServiceRuntimeException;
import com.dailycodebuffer.cricket.model.PlayerRequest;
import com.dailycodebuffer.cricket.model.PlayerResponse;
import com.dailycodebuffer.cricket.repository.PlayerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public int addPlayer(PlayerRequest playerRequest) {
        log.info("Adding Player..");

        PlayerEntity player = new PlayerEntity();
        BeanUtils.copyProperties(playerRequest,player);

        playerRepository.save(player);

        log.info("Player Created");
        return player.getPlayerId();
    }

    @Override
    public PlayerResponse getPlayerById(int playerId) {
        log.info("Get the Player for playerId: {}", playerId);

        PlayerEntity player
                = playerRepository.findById(playerId)
                .orElseThrow(
                        () -> new CricketAppServiceRuntimeException("Player with given id not found","NO_PLAYER_FOUND"));

        PlayerResponse playerResponse
                = new PlayerResponse();

        BeanUtils.copyProperties(player, playerResponse);

        return playerResponse;
    }

    @Override
    public List<PlayerResponse> getPlayers() {
        log.info("Get all Players");
        List<PlayerEntity> playerEntities
                = playerRepository.findAll();

        List<PlayerResponse> playerResponses=
                playerEntities.stream()
                .map(playerEntity -> {
                    PlayerResponse playerResponse
                            = new PlayerResponse();
                    BeanUtils.copyProperties(playerEntity, playerResponse);
                    return playerResponse;
                })
                .collect(Collectors.toList());

        return playerResponses;
    }

    @Override
    public String deletePlayerById(int playerId) {
       playerRepository.deleteById(playerId);
       return "Player with PlayerId " + playerId + " deleted successfully!";
    }

    @Override
    public List<PlayerResponse> searchPlayer(String role) {
        log.info("Search Players");
        List<PlayerEntity> playerEntities
                = playerRepository.findAllByRole(role);

        List<PlayerResponse> playerResponses=
                playerEntities.stream()
                        .map(playerEntity -> {
                            PlayerResponse playerResponse
                                    = new PlayerResponse();
                            BeanUtils.copyProperties(playerEntity, playerResponse);
                            return playerResponse;
                        })
                        .collect(Collectors.toList());

        return playerResponses;
    }
}
