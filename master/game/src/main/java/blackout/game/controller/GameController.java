package blackout.game.controller;

import blackout.game.feign_clients.GameClient;
import blackout.game.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController
{
    @Autowired
    private GameClient gameClient;

    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable(name = "id")Long id)
    {
        return gameClient.getGameById(id);
    }

    @PostMapping("/game")
    public Game addGame(@RequestBody Game game)
    {
        return gameClient.addGame(game);
    }
}
