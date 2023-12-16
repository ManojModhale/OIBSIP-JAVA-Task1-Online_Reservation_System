<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome to Reservation System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2; 
            margin: 20px;
            text-align: center;
            color: #333;
        }

        h1 {
            color: #007bff; 
            margin-bottom: 20px;
            text-decoration: underline;
        }

        h2 {
            color: #009688; 
            margin-bottom: 20px;
        }

        h4 {
            color: #333; 
            margin-bottom: 10px;
        }

        a {
            display: inline-block;
            padding: 10px;
            margin: 10px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            border: 1px solid #007bff;
            border-radius: 5px;
        }

        a:hover {
            background-color: #007bff;
            color: #fff;
        }

        p {
            color: red;
        }
    </style>
</head>
<body>

    <h1>Welcome to Home page of Reservation System</h1>
    <h2>Hello, <%= session.getAttribute("loggedInUser") %> </h2>

    <h4>For Make New Reservation Click on Below Link:</h4>
    <a href="reservation">Make Reservation</a>
    <br><br>

    <% if (request.getAttribute("error") != null) { %>
        <p><%= request.getAttribute("error") %></p>
    <% } %>

    <h4>View Reservation List or Cancellation for Reservation</h4>
    <a href="viewDetails">View Reservations</a>
    <br><br>

    <a href="logout">Logout</a>
    <br>
</body>
</html>
