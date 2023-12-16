package com.travel.demo.service;

import java.util.ArrayList;

import com.travel.demo.bean.Reservation;
import com.travel.demo.bean.User;

public interface ReservationService 
{
	public User loginUser(String loginId);
	
	public String registerUser(User user);
	
	public int makeReservations(Reservation reservation);
	
	public ArrayList<Reservation> getUserReservations(String loginId);
	
	public int CancelReservation(int ticketNo);

}
