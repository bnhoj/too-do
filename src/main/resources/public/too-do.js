function TodoCtrl($scope, $http) {
	$http.get("/lists").success(function(data) {
			$scope.lists = data;
	});
}