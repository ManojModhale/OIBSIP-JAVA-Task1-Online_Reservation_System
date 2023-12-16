<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Cancellation Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        h1 {
            color: green;
        }

        p {
            font-size: 18px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <h1>Reservation Cancellation Successful</h1>
    
    <p>Your reservation with Ticket Number ${ticketNo} has been successfully canceled.</p>

    <a style="margin-left: 15px;" href="home">HomePage</a> <a style="margin-right: 20px;" href="logout">Logout</a>

</body>
</html>
