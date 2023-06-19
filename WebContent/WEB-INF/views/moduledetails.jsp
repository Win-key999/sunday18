<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Module Details</title>
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

        /* Style the module details */
        .module-details {
            border: 1px solid #ccc;
            padding: 20px;
            background-color: #fff;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Module Details</h1>
        
        <div class="module-details">
            <h2>Module Information</h2>
            <p>Module ID: ${module.modl_id}</p>
            <p>Module Name: ${module.modl_name}</p>
            <p>Module Desc:${module.modl_desc }</p>
            <p>Project ID: ${module.modl_proj_id}</p>
        </div>
    </div>
</body>
</html>
