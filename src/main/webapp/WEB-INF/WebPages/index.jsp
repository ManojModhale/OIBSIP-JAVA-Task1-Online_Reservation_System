<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome to Reservation System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: hsla(120, 100%, 25%, 0.3);
            margin: 20px;
            text-align: center;
            color: #333;
        }

        h1 {
            color: #007bff;
            margin-bottom: 20px;
            text-decoration: underline;
        }

        .container {
            display: flex;
            justify-content: space-around;
            margin-bottom: 30px;
        }

        .container a {
            display: block;
            padding: 10px;
            margin: 10px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            border: 1px solid #007bff;
            border-radius: 5px;
        }

        .container a:hover {
            background-color: #007bff;
            color: #fff;
        }

        p {
            font-size: 22px;
            line-height: 1.6;
            text-align: left;
            margin: 0 auto;
            max-width: 800px;
        }

    </style>
</head>
<body>

    <h1>Welcome to Reservation System</h1>

    <div class="container">
        <div>
            <h4>For Login Click Here</h4>
            <a href="loginPage">Login</a>
        </div>

        <div>
            <h4>Register for New User:</h4>
            <a href="newUser">Register</a>
        </div>
    </div>

    <p>
        In today’s environment, if you have a credit card and the Internet, you can book tickets and finalize the flight
        details in a jiffy. As a result, it is expected that by 2027, 74% of total revenue in the travel and tourism market
        will be generated by online sales. Today, more than 72% of Americans prefer to plan their trips online. Despite 
        skyrocketing prices, consumers do not hesitate to pull out their credit cards and book travel online. A recent 
        survey by the Bank of America Institute showed that air travel spending is up 60% year-on-year.
    </p>


</body>
</html>
