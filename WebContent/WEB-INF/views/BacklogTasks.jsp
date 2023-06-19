<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nkxgen.spring.orm.model.Sprint" %>
<%@ page import="com.nkxgen.spring.orm.model.Task" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sprint Details</title>
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

        tr#disp:hover {
            background-color: #f5f5f5;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Backlog SprintDetails</h1>

    <% 
    Sprint sprint = (Sprint) request.getAttribute("sprint");
    %>

    <h2>Sprint <%= sprint.getSprintId() %></h2>
    <p><strong>Sprint Id:</strong> <%= sprint.getSprintId() %></p>
    <p><strong>ModuleId:</strong> <%= sprint.getModuleId() %></p>
    <p><strong>MasterId:</strong> <%= sprint.getMasterId() %></p>
    <p><strong>Start Date:</strong> <%= sprint.getStartDate() %></p>
    <p><strong>End Date:</strong> <%= sprint.getEndDate() %></p>
    <p><strong>Module ID:</strong> <%= sprint.getModuleId() %></p>
    <p><strong>Project ID:</strong> <%= sprint.getProjectId() %></p>

    <h3>Users and Tasks</h3>
    <table>
        <tr>
            <th>Task ID</th>
            <th>User ID</th>
        </tr>
        <% 
        List<Task> taskList = (ArrayList<Task>) request.getAttribute("taskList");
        for (Task task : taskList) {
            // Extract user and task information
            int taskId = task.getTask_id();
            int userId = task.getTask_supervisor();
        %>
        <tr class="clickable-row" onclick="location.href='#';" id="disp">
            <td><%= taskId %></td>
            <td><%= userId %></td>
        </tr>
        <% 
        }
        %>
    </table>

    <button onclick="window.location.href='backlog'" class="back-btn">Back to PastDue</button>

</body>
</html>
