package blackout.game.feign_clients;

import blackout.game.model.Game;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "GameClient")
public interface GameClient
{
    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable(name = "id") Long id);

    @PostMapping("/game")
    public Game addGame(@RequestBody Game game);
}
