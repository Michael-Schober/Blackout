package blackout.appointment.feignClients;

import Blackout.shared.model.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userinfo")
public interface UserClient
{
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id);

    @GetMapping("/user/check/{id}")
    public boolean checkUser(@PathVariable String id);
}
