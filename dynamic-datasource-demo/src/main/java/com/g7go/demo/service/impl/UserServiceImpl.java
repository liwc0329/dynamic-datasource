package com.g7go.demo.service.impl;

import com.g7go.demo.pojo.User;
import com.g7go.demo.repository.UserRepository;
import com.g7go.demo.service.UserService;
import com.g7go.dynamic.TargetDataSource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr_Lee
 * @date 2019-10-17 14:57
 */
@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    @TargetDataSource("ds1")
    public User data1FindUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @TargetDataSource("ds2")
    public User data2FindUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @TargetDataSource("ds3")
    public User data3FindUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    @TargetDataSource("ds1")
    public List<User> data1FindUserAll() {
        return userRepository.findAll();
    }

    @Override
    @TargetDataSource("ds2")
    public List<User> data2FindUserAll() {
        return userRepository.findAll();
    }

    @Override
    @TargetDataSource("ds3")
    public List<User> data3FindUserAll() {
        return userRepository.findAll();
    }

    /**
     * 添加新的用户
     *
     * @param user
     */
    @Override
    @TargetDataSource("ds1")
    public void data1InsertUser(User user) {
        userRepository.save(user);
    }

    @Override
    @TargetDataSource("ds2")
    public void data2InsertUser(User user) {
        userRepository.save(user);
    }

    @Override
    @TargetDataSource("ds3")
    public void data3InsertUser(User user) {
        userRepository.save(user);
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @Override
    @TargetDataSource("ds1")
    public void data1UpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @TargetDataSource("ds2")
    public void data2UpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @TargetDataSource("ds3")
    public void data3UpdateUser(User user) {
        userRepository.save(user);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    @TargetDataSource("ds1")
    public void data1DeleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @TargetDataSource("ds2")
    public void data2DeleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @TargetDataSource("ds3")
    public void data3DeleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
