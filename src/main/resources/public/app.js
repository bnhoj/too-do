var toodoApp = angular.module('toodoApp', [
'ngRoute',
'toodoControllers'
]);

toodoApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/lists', {
		templateUrl : 'lists.html',
		controller : 'ListsCtrl'
	})
//	.when('/lists/:listId', {
//		templateUrl : 'lists/list.html',
//		controller : 'ListCtrl'
//	})
	.otherwise({
		redirectTo : '/lists'
	});
} ]);