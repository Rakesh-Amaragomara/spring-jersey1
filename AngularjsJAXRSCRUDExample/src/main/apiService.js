(function(angular){
  'use strict';
// Code goes here

var myApp = angular.module('myApp',['geolocation']);
myApp.controller('mainCtrl', function ($scope,geolocation) {
    $scope.coords = geolocation.getLocation().then(function(data){
      return {lat:data.coords.latitude, long:data.coords.longitude};
    });
});

 })(win
		 
		 
		 <html>

 <head>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.1.5/angular.min.js"></script>
   <script src="https://rawgithub.com/arunisrael/angularjs-geolocation/master/dist/angularjs-geolocation.min.js"></script>
 </head>
 http://maps.googleapis.com/maps/api/geocode/json?latlng=17.48370,78.961452&sensor=true
 <body ng-app="myApp">
   <div ng-controller="mainCtrl">
     <p>Your location is: {{coords}}</p>
   </div>
 </body>

</html>dow.angular);