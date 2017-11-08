package com.example.repository;

import com.example.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by chu on 2017/11/06.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query("SELECT coalesce(max(x.id), 0) FROM Player x")
    Integer getMaxId();
}