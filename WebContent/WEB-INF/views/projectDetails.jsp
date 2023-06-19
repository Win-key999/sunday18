<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.nkxgen.spring.orm.model.ProjectModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Details</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .details {
            text-align: center;
            max-width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f8f9fa;
        }
        .alert-danger {
            color: #721c24;
            background-color: #f8d7da;
            border-color: #f5c6cb;
            padding: 10px;
            margin-top: 20px;
            border-radius: 5px;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="details">
            <h2>Project Details:</h2>
            <c:choose>
                <c:when test="${projectFound}">
                    <p class="mb-3"><strong>Project Id:</strong> ${project.proj_id}</p>
                    <p class="mb-3"><strong>Project Name:</strong> ${project.proj_Name}</p>
                    <p class="mb-3"><strong>Project Description:</strong> ${project.proj_desc}</p>
                    <p class="mb-3"><strong>Start Date:</strong> ${project.proj_stdate}</p>
                    <p class="mb-3"><strong>Manager:</strong> ${project.proj_manager}</p>
                    <p class="mb-3"><strong>Status:</strong> ${project.proj_status}</p>
                    <p class="mb-3"><strong>Last Updated Date:</strong> ${project.proj_ludate}</p>
                  
                   <div>
    <a href="modules?projectId=${project.proj_id}" class="btn btn-primary mx-2">Modules</a>
    <a href="sprints?projectId=${project.proj_id}" class="btn btn-primary mx-2">Sprints</a>
    <a href="resources?projectId=${project.proj_id}" class="btn btn-primary mx-2">Resources</a>
</div>

                </c:when>
                <c:otherwise>
                    <div class="alert alert-danger">Project not found.</div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>