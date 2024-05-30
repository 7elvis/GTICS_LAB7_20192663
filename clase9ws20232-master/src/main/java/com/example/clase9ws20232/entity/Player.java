package com.example.clase9ws20232.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "players")
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerid", nullable = false)
    private Integer playerid;
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "mmr")
    private BigInteger mmr;
    @Column(name = "position")
    private int position;

    @Column(name = "region", nullable = false, length = 100)
    private String region;

}
