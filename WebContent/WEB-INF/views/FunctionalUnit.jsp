<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .clickable-row:hover {
            background-color: #f5f5f5;
            cursor: pointer;
        }

        select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<a href="CreateFunctionalUnit">Create Functional Unit</a>
    <form action="sprints">
        <table>
            <tr>
                <th>Module Id</th>
                <th>Functional Id</th>
                <th>Description</th>
            </tr>
            <% 
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn1 = null;
            Statement stmt1 = null;
            ResultSet rs1 = null;
            
            try {
                // Establish database connection
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://192.168.110.48:5432/plf_training";
                String username = "plf_training_admin";
                String password = "pff123";
                conn = DriverManager.getConnection(url, username, password);
                
                // Execute SQL query for FunctionUnit
                String sql = "SELECT * FROM venkie_FunctionUnit";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                // Retrieve and display data
                while (rs.next()) {
                    int modl_id = rs.getInt("modl_id");
                    int func_id = rs.getInt("func_id");
                    String desc = rs.getString("func_desc");
            %>
            <tr class="clickable-row" onclick="location.href='Task';">
                <td><%= modl_id %></td>
                <td><%= func_id %></td>
                <td><%= desc %></td>
                
            </tr>
            <% 
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                // Close database connections and resources
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                    if (rs1 != null) rs1.close();
                    if (stmt1 != null) stmt1.close();
                    if (conn1 != null) conn1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            %>
        </table>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
