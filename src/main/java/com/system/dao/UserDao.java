package com.system.dao;

import com.system.model.LoginCommand;
import com.system.model.User;
import com.system.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Allen Yang
 * 2018/5/12 18:49
 */

public interface UserDao {
    //增
    void insert(User user);//插入单条数据
    int insertBatch(List<User> user);//批量插入
    //查
    User getUserByID(int id);//通过id查
    List<User> getUserByOnlineNumber(String online_number);//通过线上学号查
    List<User> getUserByName(String name);//通过名字查
    //改
    int updateUser(User user);
    //删
    int deleteUser(int UserId);
    //查询是否存在登录账号
    public int getMatchCount(@Param(value = "userName")String userName,
                             @Param(value = "password")String password);
    //查询该账号是否未被注册
    public int getMatchavailable(String userName);
    //添加一个新账户
    public void addNewlogin(LoginCommand loginCommand);

    public List<User> findPages(@Param(value = "startPos")int startPos,
                                @Param(value = "pageSize")int pageSize);
    public int countallNumber();
}
