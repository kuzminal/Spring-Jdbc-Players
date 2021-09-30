package com.example.springjdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int id;
    private String name;
    private String nationality;
    private Date birthDate;
    private int titles;
}
