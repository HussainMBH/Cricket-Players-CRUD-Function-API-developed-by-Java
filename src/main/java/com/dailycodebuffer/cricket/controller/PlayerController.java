package com.dailycodebuffer.cricket.controller;

import com.dailycodebuffer.cricket.model.PlayerRequest;
import com.dailycodebuffer.cricket.model.PlayerResponse;
import com.dailycodebuffer.cricket.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @PostMapping
    public ResponseEntity<Integer> addPlayer(@Valid @RequestBody PlayerRequest playerRequest) {
        int playerId = playerService.addPlayer(playerRequest);
        return new ResponseEntity<>(playerId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable("id") int playerId) {
        PlayerResponse playerResponse
                = playerService.getPlayerById(playerId);
        return new ResponseEntity<>(playerResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getPlayers() {
        List<PlayerResponse> players
                = playerService.getPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayerById(@PathVariable("id") int playerId) {
        String message
                = playerService.deletePlayerById(playerId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlayerResponse>> searchPlayer(
            @RequestParam("role") String role
    ) {
        List<PlayerResponse> playerResponses
                = playerService.searchPlayer(role);
        return new ResponseEntity<>(playerResponses, HttpStatus.OK);
    }
}
