package com.travel.demo.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservation23")
public class Reservation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketNo;
	@Column(length = 15)
	private String loginId;
	@Column(length = 20)
	private String trainfrom;
	@Column(length = 20)
	private String totrain;
	@Column(length = 20)
	private String trainnumber;
	@Column(length = 20)
	private String classtype;
	@Column(length = 20)
	private String journeydate;
	public Reservation() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(int ticketNo, String loginId, String trainfrom, String totrain, String trainnumber,
			String classtype, String journeydate) {
		super();
		this.ticketNo = ticketNo;
		this.loginId = loginId;
		this.trainfrom = trainfrom;
		this.totrain = totrain;
		this.trainnumber = trainnumber;
		this.classtype = classtype;
		this.journeydate = journeydate;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getTrainfrom() {
		return trainfrom;
	}
	public void setTrainfrom(String trainfrom) {
		this.trainfrom = trainfrom;
	}
	public String getTotrain() {
		return totrain;
	}
	public void setTotrain(String totrain) {
		this.totrain = totrain;
	}
	public String getTrainnumber() {
		return trainnumber;
	}
	public void setTrainnumber(String trainnumber) {
		this.trainnumber = trainnumber;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
	public String getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(String journeydate) {
		this.journeydate = journeydate;
	}
	@Override
	public String toString() {
		return "Reservation [ticketNo=" + ticketNo + ", loginId=" + loginId + ", trainfrom=" + trainfrom + ", totrain="
				+ totrain + ", trainnumber=" + trainnumber + ", classtype=" + classtype + ", journeydate=" + journeydate
				+ "]";
	}

}
