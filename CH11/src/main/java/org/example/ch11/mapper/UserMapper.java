package org.example.ch11.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.ch11.User;

@Mapper
public interface UserMapper {

    User findById(Long id);

    List<User> findAll();
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);

    List<User> findByCondition(@Param("name") String name, @Param("email") String email);
    List<User> findByIds(@Param("ids") List<Long> ids);
}
