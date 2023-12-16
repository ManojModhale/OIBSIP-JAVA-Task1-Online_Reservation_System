package com.travel.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.demo.bean.User;

public interface UserDaoDB extends JpaRepository<User, String> 
{

}
