package com.system.service.impl;

import com.system.dao.UserDao;
import com.system.model.LoginCommand;
import com.system.model.User;
import com.system.service.UserService;
import com.system.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AllenYang
 * @date 18-9-9 下午11:32
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    @Override
    public boolean getMatchavailable(String userName){
        int matchCount1 = userDao.getMatchavailable(userName);
        return matchCount1 >0;
    }

    @Override
    public void addNewlogin(LoginCommand loginCommand){
        userDao.addNewlogin(loginCommand);
    }
    @Override
    public void insert(User user) {
        this.userDao.insert(user);
    }

    @Override
    public int insertBatch(List<User> user) {
        return this.userDao.insertBatch(user);
    }

    @Override
    public User getUserByID(int userId) {
        return this.userDao.getUserByID(userId);
    }

    @Override
    public List<User> getUserByOnlineNumber(String onlineNumber) {
        return this.userDao.getUserByOnlineNumber(onlineNumber);
    }

    @Override
    public List<User> getUserByName(String userName) {
        return this.userDao.getUserByName(userName);
    }

    @Override
    public int updateUser(User user) {
        return this.userDao.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return this.userDao.deleteUser(user.getId());
    }

    @Override
    public int countallNumber(){
        return this.userDao.countallNumber();
    }

    @Override
    public List<User> findPages(int startPos, int pageSize){
        return this.userDao.findPages(startPos,pageSize);
    }
}
