<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Resource</title>
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
            margin-top: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        select {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #cccccc;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 5px 10px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Add Resource</h1>

    <form action="AddResource" method="GET">
        <label for="displayName">Display Name:</label>
        <input type="text" name="displayName" id="displayName" required><br>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br>

        <label for="emplId">Employee ID:</label>
        <input type="text" name="emplId" id="emplId" required><br>

        <label for="role">Role:</label>
        <select name="role" id="role" required>
            <option value="1">Role 1</option>
            <option value="2">Role 2</option>
            <!-- Add more options for different roles -->
        </select><br>

        <input type="submit" value="Add Resource">
    </form>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>
