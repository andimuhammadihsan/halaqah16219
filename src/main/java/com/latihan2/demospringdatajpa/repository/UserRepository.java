package com.latihan2.demospringdatajpa.repository;

import com.latihan2.demospringdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
