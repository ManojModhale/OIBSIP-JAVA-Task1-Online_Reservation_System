package com.travel.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.demo.bean.Reservation;
import com.travel.demo.bean.User;
import com.travel.demo.dao.ReservationDaoDB;
import com.travel.demo.dao.UserDaoDB;

@Service
public class ReservationServiceImpl implements ReservationService 
{
	@Autowired
	private UserDaoDB userDao;
	@Autowired
	private ReservationDaoDB reservationDao;

	


	@Override
	public User loginUser(String loginId) 
	{
		System.out.println("from form : "+loginId);
		// TODO Auto-generated method stub
		Optional<User> opUser=userDao.findById(loginId);
		
		return opUser.orElse(null);
		
		
	}	
	

	@Override
	public String registerUser(User user) 
	{
		System.out.println("Inside registerUser method of Service class");
		User user2=userDao.save(user);
		// TODO Auto-generated method stub
		return user2.getLoginId();
	}

	@Override
	public int makeReservations(Reservation reservation) 
	{
		// TODO Auto-generated method stub
		Reservation reservation2=reservationDao.save(reservation);
		return reservation2.getTicketNo();
	}

	@Override
	public ArrayList<Reservation> getUserReservations(String loginId) {
		// TODO Auto-generated method stub
		ArrayList<Reservation> rlist=(ArrayList<Reservation>) reservationDao.findAll();
		System.out.println("Inside getUserReservation after findAll() ");
		ArrayList<Reservation> reserveList=new ArrayList<>();
		Iterator<Reservation> it=rlist.iterator();
		while(it.hasNext())
		{
			Reservation robj=it.next();
			
			if(robj.getLoginId().equals(loginId))
			{
				reserveList.add(robj);
			}
		}
		
		return reserveList;
	}


	@Override
	public int CancelReservation(int ticketNo) 
	{
		// TODO Auto-generated method stub
		reservationDao.deleteById(ticketNo);
		System.out.println("after cancellation");
		return ticketNo;
	}

	

	
}
