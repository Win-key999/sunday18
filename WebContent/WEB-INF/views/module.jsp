<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Modules</title>
    <style>
        /* Apply styles to the container div */
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f2f2f2;
        }
        
        /* Style the heading */
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        /* Style the table */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        /* Style the table rows */
        tr {
            background-color: #fff;
            cursor: pointer;
        }

        /* Style the selected row */
        tr.selected {
            background-color: #ccc;
        }

        /* Style the table cells */
        td {
            padding: 8px 16px;
            border: 1px solid #ccc;
        }

        /* Style the anchor tag */
        .link {
            display: block;
            text-decoration: none;
            color: #000;
        }

        /* Style the anchor tag on hover */
        .link:hover {
            background-color: #ccc;
            border-radius: 5px;
            padding: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>List of Modules</h1>
        <table>
            <tr onclick="window.location.href='moduledetails/${module.modl_id}'">
                <th>Module ID</th>
                <th>Module Name</th>
                <th>Project ID</th>
            </tr>
            <c:forEach var="module" items="${modules}">
                <tr onclick="window.location.href='moduledetails/${module.modl_id}'">
                    <td>
                        <span class="link">
                            ${module.modl_id}
                        </span>
                    </td>
                    <td>${module.modl_name}</td>
                    <td>${module.modl_proj_id}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="createModule" class="link">Create Module</a>
    </div>
</body>
</html>
