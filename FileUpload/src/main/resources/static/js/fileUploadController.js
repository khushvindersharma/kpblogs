// CONTROLLER UPLOAD FILE
fileUploadApp.controller('fileUploadController', ['$scope', '$http', function($scope, $http){
    $scope.doUploadFile = function(){
       var file = $scope.uploadedFile;
       var url = "/FileUpload/api/fileUpload";
       
       var data = new FormData();
       data.append('uploadfile', file);
    
       var config = {
    	   	transformRequest: angular.identity,
    	   	transformResponse: angular.identity,
	   		headers : {
	   			'Content-Type': undefined
	   	    }
       }
       
       $http.post(url, data, config).then(function (response) {
			$scope.uploadResult=response.data;
		}, function (response) {
			$scope.uploadResult=response.data;
		});
    };
}]);