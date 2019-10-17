package com.g7go.demo.service;

import com.g7go.demo.pojo.User;

import java.util.List;

/**
 * @author Mr_Lee
 * @date 2019-10-17 14:56
 */
@SuppressWarnings("all")
public interface UserService {

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User data1FindUserById(int id);
    User data2FindUserById(int id);
    User data3FindUserById(int id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> data1FindUserAll();
    List<User> data2FindUserAll();
    List<User> data3FindUserAll();

    /**
     * 添加新的用户
     *
     * @param user
     */
    void data1InsertUser(User user);
    void data2InsertUser(User user);
    void data3InsertUser(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    void data1UpdateUser(User user);
    void data2UpdateUser(User user);
    void data3UpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void data1DeleteUserById(int id);
    void data2DeleteUserById(int id);
    void data3DeleteUserById(int id);

}
