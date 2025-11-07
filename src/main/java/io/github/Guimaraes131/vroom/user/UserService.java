package io.github.Guimaraes131.vroom.user;

import io.github.Guimaraes131.vroom.user.dto.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public void create(UserForm dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setRoles(List.of(dto.getRole()));
        user.setPassword(encoder.encode(dto.getPassword()));

        repository.save(user);
    }

    public User getByLogin(String login) {
        return repository.findByLogin(login);
    }
}
