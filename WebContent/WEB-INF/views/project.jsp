<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        body {
            background-color: #f8f9fa;
            padding-top: 20px;
        }

        .project-card {
            cursor: pointer;
            border-radius: 10px;
            background-color: #fff;
            transition: background-color 0.3s ease;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            height: 100%;
        }

        .project-card:hover {
            background-color: #f0f0f0;
        }

        .project-card .card-body {
            padding: 20px;
        }

        .project-card h6 {
            color: #6c757d;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .project-card h5 {
            color: #343a40;
            font-weight: 700;
            margin-bottom: 0;
        }

        .container {
            max-width: 900px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<center>
    <div class="container">
        <h2 class="mb-4">Project Details:</h2>
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <div class="col">
                <div class="card project-card" onclick="location.href='projects/addproject'">
                    <div class="card-body">
                        <h6 class="card-title">Add Project</h6>
                        <h1 class="card-text">+</h1>
                    </div>
                </div>
            </div>
            <c:forEach items="${projects}" var="project">
                <div class="col">
                    <div class="card project-card" onclick="location.href='projects/${project.proj_id}'">
                        <div class="card-body">
                            <h6 class="card-title">Project ID: ${project.proj_id}</h6>
                            <h5 class="card-text">Project Name: ${project.proj_Name}</h5>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    
    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</center>
</body>
</html>
