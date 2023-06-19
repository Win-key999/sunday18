<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resources Page</title>
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

        form {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        select {
            padding: 5px;
            border-radius: 5px;
        }

        input[type="submit"] {
            padding: 5px 10px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
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

        a {
            display: inline-block;
            margin-top: 10px;
            margin-bottom: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #ffffff;
            text-decoration: none;
            border-radius: 5px;
        }

        a:hover {
            background-color: #0056b3;
        }

        a:active {
            background-color: #003d80;
        }
    </style>
</head>
<body>
    <h1>Resources</h1>

    <form action="FilterResource" method="get">
        <label for="roleFilter">Filter by Role:</label>
        <select name="roleFilter" id="roleFilter">
            <option value="">All Roles</option>
            <% 
            try {
                // JDBC code to fetch roles from the database
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT role_name FROM Tarak_Roles");
                
                while (rs.next()) {
                    String roleName = rs.getString("role_name");
            %>
                    <option value="<%= roleName %>"><%= roleName %></option>
            <% 
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </select>
        
        <label for="projectFilter">Filter by Project:</label>
        <select name="projectFilter" id="projectFilter">
            <option value="">All Projects</option>
            <% 
            try {
                // JDBC code to fetch projects from the database
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT proj_name FROM Tarak_Projects");
                
                while (rs.next()) {
                    String projectName = rs.getString("proj_name");
            %>
                    <option value="<%= projectName %>"><%= projectName %></option>
            <% 
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </select>
        
        <label for="skillFilter">Filter by Skill:</label>
        <select name="skillFilter" id="skillFilter">
            <option value="">All Skills</option>
            <% 
            try {
                // JDBC code to fetch skills from the database
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT skill_name FROM tarak_Skills");
                
                while (rs.next()) {
                    String skillName = rs.getString("skill_name");
            %>
                    <option value="<%= skillName %>"><%= skillName %></option>
            <% 
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </select>

        <input type="submit" value="Filter">
    </form>

    <table>
        <thead>
            <tr>
                <th>Display Name</th>
                <th>Employee ID</th>
                <th>Role</th>
            </tr>
        </thead>
        <tbody>
            <%-- Apply filtering logic --%>
            <% 
            try {
                // JDBC code to fetch user information from the database
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
                Statement stmt = con.createStatement();
                
                // Construct the SQL query based on the selected filters
                String sqlQuery = "SELECT user_displayname, user_empl_id, user_role FROM tarak_users WHERE 1=1";
                
                String roleFilter = request.getParameter("roleFilter");
                if (roleFilter != null && !roleFilter.isEmpty()) {
                    sqlQuery += " AND role = '" + roleFilter + "'";
                }
                
                String projectFilter = request.getParameter("projectFilter");
                if (projectFilter != null && !projectFilter.isEmpty()) {
                    sqlQuery += " AND project = '" + projectFilter + "'";
                }
                
                String skillFilter = request.getParameter("skillFilter");
                if (skillFilter != null && !skillFilter.isEmpty()) {
                    sqlQuery += " AND skill = '" + skillFilter + "'";
                }
                
                ResultSet rs = stmt.executeQuery(sqlQuery);
                
                while (rs.next()) {
                    String displayName = rs.getString("user_displayname");
                    String employeeID = rs.getString("user_empl_id");
                    String role = rs.getString("user_role");
            %>
                <tr>
                    <td><a href="user_details?displayName=<%= displayName %>"><%= displayName %></a></td>
                    <td><%= employeeID %></td>
                    <td><%= role %></td>
                </tr>
            <% 
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </tbody>
    </table>

    <a href="AddResource">Add Resource</a>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>
