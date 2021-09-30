package com.example.springjdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="player")
@NamedQuery(name="get_all_players", query="select p from Player p")
public class Player {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(name="nationality")
    private String nationality;
    private Date birthDate;
    private int titles;

    public Player(String name, String nationality, Date birthDate, int titles) {
        super();
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }
}
