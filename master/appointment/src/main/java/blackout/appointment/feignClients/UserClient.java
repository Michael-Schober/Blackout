package blackout.appointment.feignClients;

import Blackout.shared.model.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("userinfo")
public interface UserClient
{
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id, @RequestHeader("Authorization") String token);

    @GetMapping("/user/check/{id}")
    public boolean checkUser(@PathVariable String id, @RequestHeader("Authorization") String token);
}
