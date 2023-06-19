<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Resource</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333333;
        }

        p {
            margin-top: 20px;
        }

        .success {
            color: #008000;
        }

        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
    <h1>Update Resource</h1>

    <%-- Retrieve the form data from the request --%>
    <% 
    String userID = request.getParameter("userID");
    String displayName = request.getParameter("displayName");
    String employeeID = request.getParameter("employeeID");
    String role = request.getParameter("role");
    
    try {
        // JDBC code to update user information in the database based on the user ID
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
        Statement stmt = con.createStatement();
        
        // Construct the SQL query to update user details
        String sqlQuery = "UPDATE tarak_users SET user_displayname = '" + displayName + "', user_empl_id = '" + employeeID + "', user_role = '" + role + "' WHERE user_empl_id = '" + userID + "'";
        
        int rowsAffected = stmt.executeUpdate(sqlQuery);
        
        if (rowsAffected > 0) {
            // Display a success message if the update was successful
    %>
            <p class="success">User information updated successfully.</p>
    <% 
        } else {
            // Display an error message if the update failed
    %>
            <p class="error">Failed to update user information.</p>
    <% 
        }
        
        stmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>
