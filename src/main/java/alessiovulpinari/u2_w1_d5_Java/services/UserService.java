package alessiovulpinari.u2_w1_d5_Java.services;

import alessiovulpinari.u2_w1_d5_Java.entities.User;
import alessiovulpinari.u2_w1_d5_Java.exceptions.AlreadyExistingEmailException;
import alessiovulpinari.u2_w1_d5_Java.exceptions.NotFoundException;
import alessiovulpinari.u2_w1_d5_Java.exceptions.ToShortException;
import alessiovulpinari.u2_w1_d5_Java.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User newUser) {

        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new AlreadyExistingEmailException(newUser.getEmail());
        }

        if (newUser.getCompleteName().length() <= 3 ) throw new ToShortException(newUser.getCompleteName());

        userRepository.save(newUser);

        System.out.println("L'utente con nome: " + newUser.getCompleteName() + " è stato inserito con successo!");
    }

    public User findById(String id) {
        return userRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException(id));
    }
}
