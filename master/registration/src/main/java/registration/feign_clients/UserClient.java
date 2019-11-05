package registration.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import registration.model.User;


@FeignClient(name = "DB")
public interface UserClient
{
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(name = "id")Long id);

    @PostMapping("/user")
    public User SaveUser(@RequestBody User user);


}
