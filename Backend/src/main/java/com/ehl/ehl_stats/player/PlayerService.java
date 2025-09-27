package com.ehl.ehl_stats.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {

        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {

        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getTeam().toLowerCase().contains(teamName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String serchText) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(serchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByPositionAndTeam(String position, String team) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(position.toLowerCase()) && player.getTeam().toLowerCase().contains(team.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerFromNation(String searchText) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {

        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {

        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerToUpdate.setTeam(updatedPlayer.getTeam());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName) {

        playerRepository.deleteByName(playerName);
    }
}
