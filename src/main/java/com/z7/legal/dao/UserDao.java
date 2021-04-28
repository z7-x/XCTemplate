package com.z7.legal.dao;

import com.z7.legal.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2021/4/21 11:32 上午
 * @Author z7-x
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM XC_USER WHERE NAME LIKE ?")
    Page<User> findByNameLikePage(String name, Pageable pageable);
}
