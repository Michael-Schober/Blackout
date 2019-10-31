package oauth.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDemoData implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception
    {
        User user = new User();
        user.setPassword("$2a$10$jgd4wX8/70SKqXgJIYYSme3k/edkL4mhurIBa8HDQiHkirTTLTrnK");
        user.setUsername("john");
        user.setDisabled(false);
        user.setAccountLocked(false);
        user.setAccountExpired(false);

        userRepository.save(user);
    }
}
