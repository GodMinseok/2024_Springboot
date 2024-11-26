package org.example.ch11.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch11.User;

@Mapper
public interface UserMapper {

    User findById(Long id);

}