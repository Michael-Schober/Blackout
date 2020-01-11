package blackout.userinfo.feignClients;

import Blackout.shared.model.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "roleClient", path = "/role")
public interface RoleClient
{
    @GetMapping("/{id}")
    public Set<Role> getRolesById(@PathVariable String id);
}
