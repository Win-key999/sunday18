<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nkxgen.spring.orm.model.Sprint" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sprint List</title>
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
        tr:hover {
            background-color: #f5f5f5;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Backlog Sprint List</h1>

    <table>
        <thead>
            <tr>
                <th>Sprint ID</th>
                <th>Module ID</th>
            </tr>
        </thead>
        <tbody>
            <% 
               ArrayList<Sprint> sprintList = (ArrayList<Sprint>) request.getAttribute("sprintList");
               for (Sprint sprint : sprintList) {
                   int sprnId = sprint.getSprintId();
                   int sprnModlId = sprint.getModuleId();
            %>
            <tr class="clickable-row" onclick="redirectToTaskDetails(<%= sprnModlId %>, <%= sprnId %>);">
                <td><%= sprnId %></td>
                <td><%= sprnModlId %></td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <script>
        function redirectToTaskDetails(sprnModlId, sprnId) {
            window.location.href = 'BacklogTasks?sprnModlId=' + sprnModlId + '&sprnId=' + sprnId;
        }
    </script>
</body>
</html>
