package blackout.db.controller;

import blackout.db.model.Game;
import blackout.db.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController
{

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable(name = "id")Long id) { return gameRepository.findById(id).get(); }

    @PostMapping("/game")
    public Game addGame(@RequestBody Game game) { return gameRepository.save(game); }
}
