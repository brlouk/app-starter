(function() {
	'use strict';

	angular.module('appstarter').config(routerConfig);

	/** @ngInject */
	function routerConfig($stateProvider, $urlRouterProvider) {
		$stateProvider.state('home', {
			url : '/home',
			data : {
				requireLogin : true
			},
			templateUrl : 'app/main/main.html',
			controller : 'MainController',
			controllerAs : 'main'
		}).state('user', {
			url : '/user',
			data : {
				requireLogin : true
			},
			templateUrl : 'app/user/user.html',
			controller : 'UserController',
			controllerAs : 'user'
		}).state('login', {
			url : '/login',
			data : {
				requireLogin : false
			},
			templateUrl : 'app/login/login.html',
			controller : 'LoginController',
			controllerAs : 'login'
		});

		$urlRouterProvider.otherwise('/home');
	}

})();
