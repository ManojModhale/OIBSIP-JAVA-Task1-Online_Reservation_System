package com.travel.demo.controller;


import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.travel.demo.bean.Reservation;
import com.travel.demo.bean.User;
import com.travel.demo.service.ReservationService;

@Controller
public class ReservationController 
{
	@Autowired
	private ReservationService service;
	public ReservationController() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/")
	public String showIndexPage() {
		System.out.println("inside show index Page");
		return "index";
	}
	
	@RequestMapping("/loginPage")
	public String loginUser() {
		System.out.println("inside login User");
		return "login";
	}
	
	@RequestMapping("/newUser")
	public String registerUser() {
		System.out.println("inside register User");
		return "newuser";
	}
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/registerUser")
	public ModelAndView newUserRegistration(@ModelAttribute User user) 
	{
		System.out.println("Registration of New User");
		ModelAndView mv=new ModelAndView("login");
		String loginId = service.registerUser(user);
		System.out.println("Registered User's Login Id : " + loginId);

		return mv;
	}
	
	@RequestMapping("/loginUser")
	public ModelAndView validate(@ModelAttribute User user)
	{
		System.out.println("Login of User");
		User user1=service.loginUser(user.getLoginId());
		
		if(user1!=null)
		{
			session.setAttribute("loggedInUser", user1.getLoginId());
			ModelAndView mv=new ModelAndView("home");
			//mv.addObject("status","success");
			//mv.addObject("msg1","welcome "+user1.getFirstName()+" "+user1.getLastName());
			String a=(String) session.getAttribute("loggedInUser");
			System.out.println(a);
			return mv;
			
		}
		else
		{
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("error", "Invalid LoginId or Password");
			return mv;
		}
	}
	
	@RequestMapping("/reservation")
	public String showReservationPage()
	{
		System.out.println("inside show Reservation Method");
		return "reservation";
	}
	
	@RequestMapping("/reserve")
	public ModelAndView makeReservation(@ModelAttribute Reservation reservation)
	{
		System.out.println(reservation);
		int ticketno=service.makeReservations(reservation);
		
		System.out.println("ticket No : "+ticketno);
		
		String loginUser=(String) session.getAttribute("loggedInUser");
		ArrayList<Reservation> reserveList=service.getUserReservations(loginUser);
		 
		ModelAndView mv=new ModelAndView("viewdetails");
		session.setAttribute("ReservationList", reserveList);
		return mv;
	}
	
	@GetMapping("/viewDetails")
	public ModelAndView viewdetails()
	{
		System.out.println("Inside View Details method of controller");
		String loginUser=(String) session.getAttribute("loggedInUser");
		System.out.println("inside viewdetails method login "+loginUser);
		ArrayList<Reservation> reserveList=service.getUserReservations(loginUser);
		for (Reservation reservation : reserveList) 
		{
			System.out.println(reservation);
		}
		session.setAttribute("ReservationList", reserveList);
		
		ModelAndView mv=new ModelAndView("viewdetails");
		return mv;
	}
	
	@RequestMapping("/home")
	public String gotoHomePage() {
		System.out.println("Inside method after will go to home page");
		return "home";
	}
	
	 @GetMapping("/cancel")
	 public ModelAndView cancelReservation(@RequestParam("ticketNo") int ticketNo) 
	 {
		 System.out.println("Before Cancellation Ticket Number : "+ticketNo);
		 service.CancelReservation(ticketNo);
		 ModelAndView mv=new ModelAndView("cancelConfirmation");
		 mv.addObject("ticketNo", ticketNo);
		 return mv;
	 
	 }
	 
	 @RequestMapping("/logout")
	 public String loggingOut()
	 {
		 session.invalidate();
		 System.out.println("Session invalidating with : "+session);
		 return "index";
	 }

}
