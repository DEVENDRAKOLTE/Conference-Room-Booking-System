package com.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.User;
@Repository
public interface UserConnectvity  extends JpaRepository<User, Integer>{
	Optional<User> findByNameAndPasswordAndType(String name, String password, String type);
}
