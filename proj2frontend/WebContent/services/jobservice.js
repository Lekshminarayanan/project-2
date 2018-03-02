/**
*
*/
app.factory('Job Service',function($http){
	var jobService={}
	jobService.addJob=function(job){
		return $http.post("http://localhost:8081/proj2middleware/addjob",job)
	}
	jobService.getallJobs=function(){
		return $http.get("http://localhost:8081/proj2middleware/alljobs");
	}
	jobService.getJob=function(id){
		return $http.get("http://localhost:8081/proj2middleware/getjob/"+id);
	}
	return jobService;
})