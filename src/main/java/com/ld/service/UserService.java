package com.ld.service;

import com.ld.pojo.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    public int insertUser(User u) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    public int deleteUser(int id);
    public int modifyUser(User u) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    public User queryUser(int id);
    public List<User> queryAll();
    public List<User> queryFont(int offset, int size);
    public String getPassword(String username);
}
