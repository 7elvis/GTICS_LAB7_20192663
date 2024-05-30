package com.example.clase9ws20232.repository;


import com.example.clase9ws20232.entity.Player;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByRegionOrderByMmrDesc(String region);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO players (name, mmr, region, position) VALUES (?1, ?2, ?3, 0)", nativeQuery = true)
    void insertPlayer(String name, BigInteger mmr, String region);

    @Modifying
    @Transactional
    @Query(value = "UPDATE players SET position = position + 1 WHERE mmr > ?1", nativeQuery = true)
    void updatePositions(BigInteger mmr);

    default Player reclacular(Player player) {
        insertPlayer(player.getName(), player.getMmr(), player.getRegion());
        updatePositions(player.getMmr());
        return player;
    }
}

