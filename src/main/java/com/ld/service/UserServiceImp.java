package com.ld.service;

import com.ld.dao.UserDao;
import com.ld.pojo.User;
import com.ld.util.Md5;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int insertUser(User u) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String enPassword = Md5.encryptPass(u.getPassword());
        u.setPassword(enPassword);
        return userDao.insertUser(u);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public int modifyUser(User u) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String enPassword = Md5.encryptPass(u.getPassword());
        u.setPassword(enPassword);
        return userDao.modifyUser(u);
    }

    @Override
    public User queryUser(int id) {
        return userDao.queryUser(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public List<User> queryFont(int offset, int size) {
        return userDao.queryFont(offset, size);
    }

    @Override
    public String getPassword(String username) {
        return userDao.getPassword(username);
    }




}
