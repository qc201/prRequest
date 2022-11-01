package com.qchen.pr_form.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.qchen.pr_form.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByUsername(String username);
    
}
