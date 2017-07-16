angular.module('sso.services',[]).factory('apiFactory',function($http){
	var apiFactory = {};
	apiFactory.getUser = function(cb){
		$http({
            method : 'GET',
            url : '/AngularjsJAXRSCRUDExample/rest/profile/id'
        }).then(function successCallback(response) {
           console.log(response.data);
           x="success";
           cb(x);
           
        }, function errorCallback(response) {
     	   console.log(response.data);
        });
	};
	apiFactory.updateUser = function(email,cb){
		   $http({
               method : 'GET',
               url : '/AngularjsJAXRSCRUDExample/rest/profile/user'
           }).then(function successCallback(response) {
              console.log(response.data);
              x="success";
              cb(x);
              
           }, function errorCallback(response) {
        	   console.log(response.data);
           });
	};
	return apiFactory;
});