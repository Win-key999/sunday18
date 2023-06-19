<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Subtask Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            box-sizing: border-box;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        @media (max-width: 600px) {
            .container {
                max-width: 100%;
                padding: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Subtask Form</h2>
        <form action="Taskdetails" method="get">
            <div class="form-group">
                <label for="task_id">Task ID:</label>
                <input type="number" class="form-control" id="task_id" name="task_id" required>
            </div>

            <div class="form-group">
                <label for="sbts_id">Subtask ID:</label>
                <input type="number" class="form-control" id="sbts_id" name="sbts_id" required>
            </div>

            <div class="form-group">
                <label for="sbts_parent_sbts_id">Parent Subtask ID:</label>
                <input type="number" class="form-control" id="sbts_parent_sbts_id" name="sbts_parent_sbts_id">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>