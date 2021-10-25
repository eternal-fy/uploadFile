package com.ld.dao;

import com.ld.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
    public int insertUser(User u);
    public int deleteUser(int id);
    public int modifyUser(User u);
    public User queryUser(int id);
    public List<User> queryAll();
    public List<User> queryFont(int offset, int size);
    public String getPassword(String username);
}
