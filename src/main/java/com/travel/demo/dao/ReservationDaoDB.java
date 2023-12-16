package com.travel.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.demo.bean.Reservation;

public interface ReservationDaoDB extends JpaRepository<Reservation, Integer> 
{

}
