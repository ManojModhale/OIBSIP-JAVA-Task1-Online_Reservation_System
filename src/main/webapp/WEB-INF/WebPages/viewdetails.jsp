<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.travel.demo.bean.Reservation"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Details</title>
    <style>
    	h3{
    	color: blue;
    	text-decoration: underline;
    	}
        table {
            border-collapse: collapse;
            width: 80%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

    <h1 style="background-color: aqua;" align="center">Reservation Details</h1>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <br>
    
    <a style="margin-left: 15px;" href="home">HomePage</a> <a style="margin-right: 20px;" href="logout">Logout</a>
    
    <br>
    
    <% 
        ArrayList<Reservation> reserveList = (ArrayList<Reservation>) session.getAttribute("ReservationList");
        if (reserveList != null && !reserveList.isEmpty()) {
            System.out.println("Size of reserveList: " + reserveList.size());
    %>
    <table>
        <thead>
            <tr>
            	<th>Ticket No</th>
                <th>Reservation User ID</th>
                <th>Place From</th>
                <th>Destination</th>
                <th>Train Number</th>
                <th>Class Type</th>
                <th>Date of Journey</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <% for (int i = 0; i < reserveList.size(); i++) {
                Reservation reservation = reserveList.get(i);
        %>
            <tr>
            	<td><%= reservation.getTicketNo() %></td>
                <td><%= reservation.getLoginId() %></td>
                <td><%= reservation.getTrainfrom() %></td>
                <td><%= reservation.getTotrain() %></td>
                <td><%= reservation.getTrainnumber() %></td>
                <td><%= reservation.getClasstype() %></td>
                <td><%= reservation.getJourneydate() %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/cancel?ticketNo=<%= reservation.getTicketNo() %>">CancelReservation</a>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
        <h3>No Reservations found.</h3>
    <% } %>

</body>
</html>
