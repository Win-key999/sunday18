<!DOCTYPE html>
<html>
<head>
  <title>Your JSP Page</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body onload="dubCall()">
  <label for="resourceIdInput">Resource ID:</label>
  <input type="number" id="resourceIdInput" name="resourceId" required>
  <button onclick="dubber()">Submit</button>

  <div class="chart-row">
    <div class="chart-container">
      <h1>Project Wise Time spent(Hrs)</h1>
      <h1 id="nores"></h1>
      <canvas id="pieChart"></canvas>
    </div>

    <div class="chart-container">
      <h1>Module Wise Time spent(Hrs)</h1>
      <h1 id="noresModule"></h1>
      <canvas id="pieChartModule"></canvas>
    </div>
  </div>

  <div class="chart-row">
    <div class="chart-container">
      <h1>Task Wise Time spent(Hrs)</h1>
      <h1 id="noresTask"></h1>
      <canvas id="pieChartTask"></canvas>
    </div>

    <div class="chart-container">
      <h1>SubTask Wise Time spent(Hrs)</h1>
      <h1 id="noresSubTask"></h1>
      <canvas id="pieChartSubTask"></canvas>
    </div>
  </div>

  <script>
  var pieChart = null;
  var pieChartModule = null;
  var pieChartTask = null;
  var pieChartSubTask = null;

  function dubCall() {
    createChart("pieChart", [100], ['#dddddd']);
    createChart("pieChartModule", [100], ['#dddddd']);
    createChart("pieChartTask", [100], ['#dddddd']);
    createChart("pieChartSubTask", [100], ['#dddddd']);
  }

  function createChart(chartId, data, backgroundColors) {
    var chartCanvas = document.getElementById(chartId);
    var chart;
    if (chartId === "pieChart") {
      chart = pieChart;
    } else if (chartId === "pieChartModule") {
      chart = pieChartModule;
    } else if (chartId === "pieChartTask") {
      chart = pieChartTask;
    } else if (chartId === "pieChartSubTask") {
      chart = pieChartSubTask;
    }

    if (chart) {
      chart.destroy();
    }

    chart = new Chart(chartCanvas, {
      type: 'pie',
      data: {
        labels: ['Select Resource'],
        datasets: [{
          data: data,
          backgroundColor: backgroundColors,
          borderWidth: 0
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        tooltips: {
          enabled: false
        },
        plugins: {
          legend: {
            display: false
          }
        }
      }
    });

    if (chartId === "pieChart") {
      pieChart = chart;
    } else if (chartId === "pieChartModule") {
      pieChartModule = chart;
    } else if (chartId === "pieChartTask") {
      pieChartTask = chart;
    } else if (chartId === "pieChartSubTask") {
      pieChartSubTask = chart;
    }
  }

  function dubber() {
    var resourceId = $("#resourceIdInput").val();

    $.ajax({
      type: "POST",
      url: "getProjAnaById",
      data: {
        "user_id": resourceId
      },
      success: function(response) {
        var projectWorkingHoursMap = JSON.parse(response);

        if (Object.keys(projectWorkingHoursMap).length === 0) {
          document.getElementById("nores").innerHTML = "No such resource";
          document.getElementById("noresModule").innerHTML = "No such resource";
          document.getElementById("noresTask").innerHTML = "No such resource";
          document.getElementById("noresSubTask").innerHTML = "No such resource";
          destroyChart();
          return;
        }

        document.getElementById("nores").innerHTML = "";
        document.getElementById("noresModule").innerHTML = "";
        document.getElementById("noresTask").innerHTML = "";
        document.getElementById("noresSubTask").innerHTML = "";

        var projectNames = Object.keys(projectWorkingHoursMap);
        var workingHours = Object.values(projectWorkingHoursMap);
        var colors = generateRandomColors(projectNames.length);

        createChart("pieChart", workingHours, colors);
        createChart("pieChartModule", workingHours, colors);
        createChart("pieChartTask", workingHours, colors);
        createChart("pieChartSubTask", workingHours, colors);

        pieChart.data.labels = projectNames;
        pieChartModule.data.labels = projectNames;
        pieChartTask.data.labels = projectNames;
        pieChartSubTask.data.labels = projectNames;

        pieChart.update();
        pieChartModule.update();
        pieChartTask.update();
        pieChartSubTask.update();
      },
      error: function(error) {
        console.log(error);
      }
    });
  }

  function destroyChart() {
    if (pieChart) {
      pieChart.destroy();
      pieChart = null;
    }
    if (pieChartModule) {
      pieChartModule.destroy();
      pieChartModule = null;
    }
    if (pieChartTask) {
      pieChartTask.destroy();
      pieChartTask = null;
    }
    if (pieChartSubTask) {
      pieChartSubTask.destroy();
      pieChartSubTask = null;
    }
  }

  function generateRandomColors(numColors) {
    var colors = [];
    for (var i = 0; i < numColors; i++) {
      var color = '#' + Math.floor(Math.random() * 16777215).toString(16);
      colors.push(color);
    }
    return colors;
  }
  </script>

  <style>

  .chart-row {
    display: flex;
    margin-bottom: 100px;
    margin-top: 20px;
  }

  .chart-container {
    flex: 1;
    width: 100%;
    max-width: 500px;
    height: 600px;
    margin: 10px 70px 10px 10px;
    background-color: #f5f5f5;
    border: 1px solid #ccc;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1), 0 8px 24px rgba(0, 0, 0, 0.1);
  }

  .h1{
  margin-bottom:-70px;
  }



</style>
</body>
</html>
