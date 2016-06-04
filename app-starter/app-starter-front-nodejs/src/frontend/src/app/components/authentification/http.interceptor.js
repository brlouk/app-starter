(function() {
	'use strict';

	angular.module('appstarter').factory('htppInterceptor', htppInterceptor);

	/** @ngInject */
	function htppInterceptor($cookies, $q,$injector) {
		var headerName = 'X-XSRF-TOKEN';
		var cookieName = 'XSRF-TOKEN';
		var allowedMethods = [ 'GET' ];
		return {
			'request' : function(config) {
				if (allowedMethods.indexOf(config.method) === -1) {
					// do something on success
					config.headers[headerName] = $cookies.get(cookieName);
				}
				return config;
			},
			'responseError' : function(response) {
				// do something on error
				if (response.status === 401 || response.status === 403) {
					$injector.get('authService').invalidateSession();
					return $q.reject(response);
				}
				return $q.reject(response);
			}

		};
	}

})();