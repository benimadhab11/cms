package com.bmk.cms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bmk.cms.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);
	
}