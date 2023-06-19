<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
    <style>
    
    </style>
</head>
<body>
    <h1>User Details</h1>

    <%-- Retrieve the display name parameter from the URL --%>
    <% 
    String displayName = request.getParameter("displayName");
    
    try {
        // JDBC code to fetch user information from the database based on the display name
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
        Statement stmt = con.createStatement();
        
        // Construct the SQL query to retrieve user details
        String sqlQuery = "SELECT * FROM tarak_users WHERE user_displayname = '"+ displayName +"'";
        
        ResultSet rs = stmt.executeQuery(sqlQuery);
        
        if (rs.next()) {
            String employeeID = rs.getString("user_empl_id");
            String role = rs.getString("user_role");
            
            // Display user details
    %>
            <table>
                <tr>
                    <th>Display Name:</th>
                    <td><%= displayName %></td>
                </tr>
                <tr>
                    <th>Employee ID:</th>
                    <td><%= employeeID %></td>
                </tr>
                <tr>
                    <th>Role:</th>
                    <td><%= role %></td>
                </tr>
            </table>
            
            <a href="edit_resource?user_id=<%= employeeID %>">Edit</a>
    <% 
        } else {
            // Display a message if user details are not found
            out.println("User details not found.");
        }
        
        rs.close();
        stmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>
