package com.joapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joapp.application.domain.User;

@Repository("JoappUserRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
