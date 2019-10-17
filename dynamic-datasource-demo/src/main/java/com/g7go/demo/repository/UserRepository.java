package com.g7go.demo.repository;

import com.g7go.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mr_Lee
 * @date 2019-10-17 14:51
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
