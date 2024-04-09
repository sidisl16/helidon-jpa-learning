package edu.sid.learning.services;


import edu.sid.learning.dtos.UserDto;
import edu.sid.learning.entities.User;
import edu.sid.learning.repositories.UserRepository;
import edu.sid.learning.util.Converter;
import edu.sid.learning.util.UserConverter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Collection;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Converter<UserDto, User> converter;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.converter = new UserConverter();
    }

    @Override
    public Collection<UserDto> getAll() {
        return converter.fromEntity(userRepository.findAll());
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public UserDto add(User user) {
        return converter.fromEntity(userRepository.save(user));
    }
}
