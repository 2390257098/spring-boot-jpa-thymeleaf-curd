package com.neo.repository;

import com.neo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    User findById(long id);

    Long deleteById(Long id);

    List<User> getUserList();

    void save(User user);

    void edit(User user);


}