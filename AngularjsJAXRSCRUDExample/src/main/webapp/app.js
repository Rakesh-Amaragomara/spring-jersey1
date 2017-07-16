angular.module('sso', ['ngRoute','sso.controllers', 'sso.services']);

angular.module('sso').config(function($routeProvider){
	$routeProvider
	.when('/profile',{
		templateUrl:'profile.html',
		controller:'profileCtrl'
	})
	.when('/changePWD',{
		templateUrl:'changepassword.html',
		controller:'chngePwdCtrl'
	})
	.when('/updateEmail',{
		templateUrl:'updateEmail.html',
		controller:'updateEmailCtrl'
	})
});
