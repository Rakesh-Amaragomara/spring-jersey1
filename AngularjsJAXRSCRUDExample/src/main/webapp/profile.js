angular.module('sso.controllers',[])

.controller('profileCtrl',['$scope','apiFactory',function($scope,apiFactory){
	$scope.message ="happy";
	apiFactory.getUser(function(r){
		$scope.message = r;
		console.log($scope.message);
	});
}])
.controller('chngePwdCtrl',['$scope','apiFactory',function($scope,apiFactory){}])
.controller('updateEmailCtrl',['$scope','apiFactory',function($scope,apiFactory){}]);