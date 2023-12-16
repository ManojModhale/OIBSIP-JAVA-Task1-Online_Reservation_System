<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa; /* Light Gray Background */
            margin: 20px;
            text-align: center;
            color: #333;
        }

        h2 {
            color: #007bff; /* Blue Header */
            margin-bottom: 20px;
            text-decoration: underline;
        }

        form {
            width: 30%;
            margin: auto;
            display: grid;
            grid-gap: 10px;
            border: 2px solid black;
            border-radius: 10px;
            padding: 20px 50px;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
        }

        input, select, date {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        select {
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: #28a745; /* Green Submit Button */
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        p {
            color: red;
        }
    </style>
</head>
<body>

    <h2>Reservation Page</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="reserve" method="post">
        <label for="loginId">Login ID :</label>
        <input type="text" id="loginId" name="loginId" value="<%= session.getAttribute("loggedInUser") %>" readonly>

        <label for="trainfrom">Station From :</label>
        <input type="text" id="trainfrom" name="trainfrom" required>

        <label for="totrain">To Station :</label>
        <input type="text" id="totrain" name="totrain" required>

        <label for="trainnumber">Train Number:</label>
        <input type="text" id="trainnumber" name="trainnumber" required>

        <label for="classtype">Class Type:</label>
        <select id="classtype" name="classtype" required>
            <option value="firstClass">First Class</option>
            <option value="secondClass">Second Class</option>
            <option value="sleeper">Sleeper</option>
        </select>

        <label for="journeydate">Date of Journey:</label>
        <input type="date" id="journeydate" name="journeydate" required>

        <input type="submit" value="Submit Reservation">
    </form>
</body>
</html>
