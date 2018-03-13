/**
 * Angular JS module and configuration SPA
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
	.when('/addblog',{
		templateUrl:'views/blogform.html',
			controller:'BlogCtrl'
	})
	.when('/blogsnotapproved',{
		templateUrl:'views/blogsnotapproved.html',
			controller:'BlogCtrl'
	})
	.when('/blogsapproved',{
		templateUrl:'views/blogsapproved.html',
			controller:'BlogCtrl'
	})
	when('/getblog/:id',{
		templateUrl:'views/blogdetails.html',
			controller:'BlogDetailsCtrl'
	})
	when('/getblognotapproved/:id',{
		templateUrl:'views/blogapprovalform.html',
			controller:'BlogDetailsCtrl'
	})
	when('/getnotification/:id',{
		templateUrl:'views/notificationdetails.html',
			controller:'NotificationCtrl'
	})

	when('/home',{
		templateUrl:'views/home.html',
			controller:'NotificationCtrl'
	})
	when('/uploadprofilepic',{
		templateUrl:'views/uploadprofilepic.html',
			
	})
	.otherwise({
		templateUrl:'views/home.html',
			controller:'NotificationCtrl'
	})
	app.run(function($location,$rootScope,$cookiesStore){
	if($rootScope.loggedInUser==undefined)	
		$rootScope.loggedInUser==$cookiesStore.get('currentuser')
		
		$rootScope.logout=function(){
		console.log('entering logout')
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