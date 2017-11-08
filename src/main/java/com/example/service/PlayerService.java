package com.example.service;

import com.example.domain.Player;
import com.example.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chu on 2017/11/06.
 */
@Service
public class PlayerService {
    // ①
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findOne(Integer id) {
        return playerRepository.findOne(id);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(Integer id) {
        playerRepository.delete(id);
    }

    public Integer getMaxId() {
        return playerRepository.getMaxId();
    }
}