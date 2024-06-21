package alessiovulpinari.u2_w1_d5_Java.services;

import alessiovulpinari.u2_w1_d5_Java.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
}
