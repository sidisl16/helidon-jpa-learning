package edu.sid.learning.services;

import edu.sid.learning.dtos.UserDto;
import edu.sid.learning.entities.User;

import java.util.Collection;

public interface UserService {

    Collection<UserDto> getAll();

    UserDto add(User user);
}
