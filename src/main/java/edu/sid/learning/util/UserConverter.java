package edu.sid.learning.util;

import edu.sid.learning.dtos.UserDto;
import edu.sid.learning.entities.User;
import org.modelmapper.ModelMapper;

public class UserConverter extends Converter<UserDto, User> {

    private static final ModelMapper modelMapper = new ModelMapper();

    public UserConverter() {
        super(d -> modelMapper.map(d, User.class), e -> modelMapper.map(e, UserDto.class));
    }
}