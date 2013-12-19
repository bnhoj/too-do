var toodoControllers = angular.module('toodoControllers', []);

toodoControllers.controller('ListsCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get("/lists").success(function(data) {
				$scope.lists = data;
			});

		} ]);

