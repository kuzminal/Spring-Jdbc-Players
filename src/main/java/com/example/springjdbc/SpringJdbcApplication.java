package com.example.springjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(SpringJdbcApplication.class);
    @Autowired
    PlayerRepository repo;

    @Autowired
    PlayerSpringDataRepository repoDataJpa;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) {
        //insert players
        logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
        logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
                new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));
        logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
                new Player("Thiem", "Austria",
                        new Date(System.currentTimeMillis()), 17)));
        //get all players
        logger.info("All Players Data: {}", repo.getAllPlayers());
        //update player
        logger.info("\n\n>> Updating Player with Id 3: {}\n", repo.updatePlayer(
                new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
        //get player
        logger.info("\n\n>> Player with id 3: {}\n", repo.getPlayerById(3));
        //delete player
        repo.deletePlayerById(2);

        //data jpa
        //Inserting rows
        logger.info("Inserting Player: {}", repoDataJpa.save(new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
        logger.info("Inserting Player: {}", repoDataJpa.save(new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));
        logger.info("Inserting Player: {}", repoDataJpa.save(new Player("Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));
        //Updating row
        logger.info("Updating Player with Id 3: {}", repoDataJpa.save(new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
        logger.info("Player with Id 2: {}", repoDataJpa.findById(6));
        logger.info("All Players Data: {}", repoDataJpa.findAll());
        repoDataJpa.deleteById(6);
        logger.info("All Players from France: {}", repoDataJpa.findByNationality("France"));
    }
}
