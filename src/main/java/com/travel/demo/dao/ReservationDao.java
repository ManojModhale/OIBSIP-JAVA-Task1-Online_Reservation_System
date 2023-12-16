package com.travel.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.travel.demo.bean.Reservation;
import com.travel.demo.bean.User;

public class ReservationDao 
{
	public boolean loginPassenger(Connection con,User user)
	{
		boolean ans=false;
		String query1="select * from passenger where loginId=?";
		try
		{
			PreparedStatement pstat=con.prepareStatement(query1);
			pstat.setString(1,user.getLoginId());
			ResultSet rs=pstat.executeQuery();
			rs.next();
			if((user.getLoginId()).equals(rs.getString(1)) && (user.getPassword()).equals(rs.getString(2)) )
			{
				ans=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	public int makeReservations(Connection con,Reservation reservation)
	{
		int rows=0;
		String insert="insert into reservation values (?,?,?,?,?,?)";
		
		try
		{
			PreparedStatement pstat=con.prepareStatement(insert);
			pstat.setString(1, reservation.getLoginId());
			pstat.setString(2, reservation.getTrainfrom());
			pstat.setString(3, reservation.getTotrain());
			pstat.setString(4, reservation.getTrainnumber());
			pstat.setString(5, reservation.getClasstype());
			pstat.setString(6, reservation.getJourneydate());
			rows=pstat.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	
	public ArrayList<Reservation> getUserReservations(Connection con,String loginId)
	{
		String query2="select * from reservation where loginId=?";
		ArrayList<Reservation> reserveList=new ArrayList<Reservation>();
		try
		{
			PreparedStatement pstat=con.prepareStatement(query2);
			pstat.setString(1,loginId);
			ResultSet rs=pstat.executeQuery();
			
			while(rs.next())
			{
				int trainno=rs.getInt(1);
				String loginid=rs.getString(2);
				String trainfrom=rs.getString(3);
				String totrain=rs.getString(4);
				String trainnumber=rs.getString(5);
				String classtype=rs.getString(6);
				String journeydate=rs.getString(7);
				
				Reservation reservation=new Reservation(trainno,loginid, trainfrom, totrain, trainnumber, classtype, journeydate);
				reserveList.add(reservation);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return reserveList;
	}
	
	public int CancelReservation(Connection con,String loginId,String journeydate )
	{
		String delete="DELETE FROM reservation WHERE loginId=? AND journeydate=?";
		int rows=0;
		try
		{
			PreparedStatement pstat=con.prepareStatement(delete);
			pstat.setString(1,loginId);
			pstat.setString(2, journeydate);
			rows=pstat.executeUpdate();
			System.out.println("Inside dao method");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rows;
	}
}
