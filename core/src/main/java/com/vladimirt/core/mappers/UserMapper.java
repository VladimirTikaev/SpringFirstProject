package com.vladimirt.core.mappers;

import com.vladimirt.core.dto.UserDTO;
import com.vladimirt.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDTO toDTO(User user);
}
