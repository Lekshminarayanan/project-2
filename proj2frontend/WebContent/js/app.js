/**
 * Angular JS module and config SPA
 */
var app=angular.module('app',['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/register',{
		templateUrl:'views/registrationform.html',
		controller:'UserController'
	})
	.when('/login',{
		templateUrl:'views/login.html',
		controller:'UserController'
	})
	.when('/edituserprofile',{
		templateUrl:'views/edituserprofilr.html',
			controller:'UserController'
	})
	.when('/addjob',{
		templateUrl:'views/jobform.html',
			controller:'JobController'
	})
	.when('/alljobs',{
		templateUrl:'views/jobslist.html',
			controller:'JobCtrl'
	})
	.when('/getjob/:id',{
		templateUrl:'views/jobdetail.html',
			controller:'JobCtrl'
	})
	.otherwise({
		templateUrl:'views/home.html'
	})
	app.run(function($location,$rootScope,$cookiesStore){
	if($rootScope.loggedInUser==undefined)	
		$rootScope.loggedInUser==$cookiesStore.get('currentuser')
		
		$rootScope.logout=function(){
		UserService.logout().then(
				function(response){
			delete $rootScope.loggedInUser;
			$cookiesStore.remove('currentuser')
			$rootScope.message="Successfully loggedout.."
				$location.path('/login')
		},function(response){
			$rootScope.error=response.data
			if(response.status==401)
				$location.path('/login')
		})
	}
	})
})