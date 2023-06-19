<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sub-Task Details</title>
    <style>
        .back-btn {
            padding: 5px 10px;
            background-color: #f5f5f5;
            color: #333;
            text-decoration: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 12px;
            cursor: pointer;
        }
    </style>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }

        h1, h2, h3 {
            color: #333333;
        }

        h1 {
            text-align: center;
        }

        h2 {
            margin-top: 20px;
        }

        p {
            margin: 10px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #cccccc;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        a.back-btn {
            display: block;
            margin-top: 20px;
            margin-bottom: 20px;
            text-align: center;
            text-decoration: none;
            color: #ffffff;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
        }

        a.back-btn:hover {
            background-color: #0056b3;
        }

        a.back-btn:active {
            background-color: #003d80;
        }
    </style>
</head>
<body>
    <h1>Sub-Task Details</h1>

    <% 
    Connection con = null;
    Statement stmt = null;
    ResultSet subtaskRs = null;

    try {
        // JDBC code to fetch subtask details from the database
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
        stmt = con.createStatement();      
        subtaskRs = stmt.executeQuery("SELECT * FROM s4_subtask WHERE sbts_id = 1");     
        while (subtaskRs.next()) {
            // Extract subtask information
            int taskId = subtaskRs.getInt("task_id");
            int subtaskId = subtaskRs.getInt("sbts_id");
            int subtaskParentId = subtaskRs.getInt("sbts_parent_sbts_id");
    %>
            <table>
                <tr>
                    <td>Task Id:</td>
                    <td><%= taskId %></td>
                </tr>
                <tr>
                    <td>SubTask Id:</td>
                    <td><%= subtaskId %></td>
                </tr>
                <tr>
                    <td>SubTask Parent Id:</td>
                    <td><%= subtaskParentId %></td>
                </tr>
            </table>
    <%
        }
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        // Close the database resources
        try {
            if (subtaskRs != null) {
                subtaskRs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    %>

</body>
</html>
