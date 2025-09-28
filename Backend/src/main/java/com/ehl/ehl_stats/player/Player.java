package com.ehl.ehl_stats.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_data")
public class Player {

    @Id
    @Column(name = "player_name", unique = true)
    private String name;
    private String pos;
    private String team;
    private Integer gp;
    private Integer g;
    private Integer a;
    private Integer p;
    private Integer pim;
    private String nation;

    public Player() {
    }

    public Player(String name, String pos, String team, Integer gp, Integer g, Integer a, Integer p, Integer pim, String nation) {
        this.name = name;
        this.pos = pos;
        this.team = team;
        this.gp = gp;
        this.g = g;
        this.a = a;
        this.p = p;
        this.pim = pim;
        this.nation = nation;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGp() {
        return gp;
    }

    public void setGp(Integer gp) {
        this.gp = gp;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getPim() {
        return pim;
    }

    public void setPim(Integer pim) {
        this.pim = pim;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
