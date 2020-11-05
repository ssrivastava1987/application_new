package com.dyt.doyourthing.repositories;

import com.dyt.doyourthing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByName(String name);

    User findByUserName(String userName);

//    @Query(value="SELECT * FROM USER u WHERE u.ADDRESS_ID = (SELECT a.ADDRESS_ID FROM ADDRESS a WHERE a.STREET LIKE %?1%)",nativeQuery = true)
    @Query(value="SELECT * FROM USER u WHERE u.ADDRESS_ID = (SELECT a.ADDRESS_ID FROM ADDRESS a WHERE a.STREET = ?1)",nativeQuery = true)
    List<User> findByStreet(String street);
}
