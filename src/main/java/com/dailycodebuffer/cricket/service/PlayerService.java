package com.dailycodebuffer.cricket.service;

import com.dailycodebuffer.cricket.model.PlayerRequest;
import com.dailycodebuffer.cricket.model.PlayerResponse;

import java.util.List;

public interface PlayerService {
    int addPlayer(PlayerRequest playerRequest);

    PlayerResponse getPlayerById(int playerId);

    List<PlayerResponse> getPlayers();

    String deletePlayerById(int playerId);

    List<PlayerResponse> searchPlayer(String role);
}
