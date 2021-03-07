package com.github.TheGameNG.entities;


import lombok.Data;


import javax.persistence.*;

//CREATE TABLE teams (id INT PRIMARY KEY AUTO_INCREMENT, teamName VARCHAR(200), teamPlayZone VARCHAR(50), teamRank DOUBLE, championships INT,
//                    goldMedal INT, silverMedal INT, bronzeMedal INT, forceGoal DOUBLE, forceDEF DOUBLE,
//                     forceDEMI DOUBLE, forceATT DOUBLE);

@Data
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "team_play_zone")
    private String teamPlayZone;

    @Column(name = "team_rank")
    private double teamRank;

    @Column(name = "championships")
    private int championships;

    @Column(name = "gold_medal")
    private int goldMedal;

    @Column(name = "silver_medal")
    private int silverMedal;

    @Column(name = "bronze_medal")
    private int bronzeMedal;

    @Column(name = "force_goal")
    private double forceGoal;

    @Column(name = "force_def")
    private double forceDef;

    @Column(name = "force_demi")
    private double forceDemi;

    @Column(name = "force_att")
    private double forceAtt;

    public Team() {
    }

}
