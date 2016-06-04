(function() {
	'use strict';

	angular.module('appstarter').factory('authService', authService);

	/** @ngInject */
	function authService($log, $state, $sessionStorage, $http, loginService,config) {
		return {
			authorize : function(requireLogin, event) {
				if (requireLogin === true) {
					// var principal = $sessionStorage.principal;
					// if (angular.isUndefined(principal) || principal === null)
					// {
					// event.preventDefault();
					// $state.go('login');
					// }
					loginService.login().then(function(result) {
						$sessionStorage.principal = result.data;
					}, function() {
					});

				}
			},
			invalidateSession : function() {
				function logout() {
					$sessionStorage.$reset();
					$state.go('login');
				}
				return $http.get(config.apiURL + config.secureBase +'/logout').then(
						function() {
							logout();
						}, function() {
							logout();
						});
			}
		};
	}
})();