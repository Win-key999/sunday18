<%@ page import="java.sql.*,com.nkxgen.spring.orm.model.Task,com.nkxgen.spring.orm.model.SubTasks,java.util.List,java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Details</title>
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
    <h1>Task Details</h1>

    <% Task task = (Task) request.getAttribute("mytask");
       List<SubTasks> mysubtasks = (List<SubTasks>) request.getAttribute("mysubtask"); 
    %>
            <table>
                <tr>
                    <td>Task Id:</td>
                    <td><%= task.getTask_id() %></td>
                </tr>
                <tr>
                    <td>Task Name:</td>
                    <td><%= task.getTask_name() %></td>
                </tr>
                <tr>
                    <td>Task Description:</td>
                    <td><%= task.getTask_desc() %></td>
                </tr>
                <tr>
                    <td>Task Expiry-date:</td>
                    <td><%=  task.getTask_exp_datetime() %></td>
                </tr>
                <tr>
                    <td>Task Status:</td>
                    <td><%= task.getTask_status() %></td>
                </tr>
            </table>
            <a href="createsubtask">Create Sub Task</a>
    <h1>Sub Task Details</h1>

<div style="text-align: center;">

    
    <table>
        <tr>
            <th style="max-width: 300px;">Subtask Id:</th>
            <th style="max-width: 300px;">Task Id:</th>
            <th style="max-width: 300px;">Subtask Parent Subtask Id:</th>
        </tr>
        <% for (SubTasks subts : mysubtasks) { %>
        <tr class="clickable-row" onclick="location.href='SubTaskdetails';">
            <td style="max-width: 300px;"><%= subts.getSbts_id() %></td>
            <td style="max-width: 300px;"><%= subts.getTask_id() %></td>
            <td style="max-width: 300px;"><%= subts.getSbts_parent_sbts_id() %></td>
        </tr>
        <% } %>
    </table>
</div>
</div>

</body>

    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
        }
        
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        .clickable-row {
            cursor: pointer;
        }
    </style>
</html>
