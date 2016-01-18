function getJobs() {
  $.getJSON(
    '/api/jobs',
    '',
    function(jobs) {
      $('#failedJobsTable tbody').empty();
      $('#runningJobsTable tbody').empty();
      $('#completedJobsTable tbody').empty();

      $.each(jobs, function(key, job) {
        var items = [];
        items.push("<tr>");
        items.push("<td>" + job.jobId + "</td>");
        items.push("<td>" + job.classPath + "</td>");
        items.push("<td>" + job.context + "</td>");
        items.push("<td>" + job.startTime + "</td>");
        items.push("<td>" + job.duration + "</td>");
        items.push("<td><button type='button' class='btn btn-default result_button' id='" + job.jobId +"' >查看结果</button></td>");
        items.push("<td><button type='button' class='del_job close' id='" + job.jobId +"'>×</button></td>");
        items.push("</tr>");

        if(job.status == 'ERROR') {
          $('#failedJobsTable > tbody:last').append(items.join(""));
        } else if(job.status == 'RUNNING') {
          $('#runningJobsTable > tbody:last').append(items.join(""));
        } else {
          $('#completedJobsTable > tbody:last').append(items.join(""));
        }
      });
    });
}

function getContexts() {
  $.getJSON(
    '/api/contexts',
    '',
    function(contexts) {
      $('#contextsTable tbody').empty();

      $.each(contexts, function(key, contextName) {
        var items = [];
        items.push("<tr><td>" + contextName + "</td><td><button type='button' class='del_context close' id='" + contextName +"'>×</button></td></tr>");
        $('#contextsTable > tbody:last').append(items.join(""));
      });
    });
}

function getJars() {
  $.getJSON(
    '/api/jars',
    '',
    function(jars) {
      $('#jarsTable tbody').empty();

      $.each(jars, function(jarName, deploymentTime) {
        var items = [];
        items.push("<tr>");
        items.push("<td>" + jarName + "</td>");
        items.push("<td>" + deploymentTime + "</td>");
        items.push("</tr>");
        $('#jarsTable > tbody:last').append(items.join(""));
      });
    });
}

$(document).ready(getJobs());
$(document).ready(getContexts());
$(document).ready(getJars());

$(function () {
  $('#navTabs a[data-toggle="tab"]').on('show.bs.tab', function (e) {
    var target = $(e.target).attr("href");

    if (target == '#jobs') {
      getJobs();
    } else if (target == "#contexts") {
      getContexts();
    } else {
      getJars();
    }
  });
  
  
  $("#contextsTable").on("click",".del_context",function(){
	  $.ajax({
			url: "/api/contexts/" + $(this).attr("id"),
			type: 'DELETE',
			processData: false,
			contentType: false,
			success: function(d) {
			$("#context_message").html(d);
			setTimeout(function(){
				getContexts();
				},1000)
			}
		});
  });
  
  $("#runningJobsTable").on("click",".del_job",function(){
	  $.ajax({
			url: "/api/jobs/" + $(this).attr("id"),
			type: 'DELETE',
			processData: false,
			contentType: false,
			success: function(d) {
			$("#job_message").html(d);
			setTimeout(function(){
				getContexts();
				},1000)
			}
		});
  });
  
  
  $(".table").on("click",".result_button",function(){
	  $.ajax({
			url: "/api/jobs/" + $(this).attr("id"),
			type: 'GET',
			processData: false,
			contentType: false,
			success: function(d) {
			$("#job_message").html(JSON.stringify(d));
			}
		});
	  
  });
  
  
  
});
