(function() {
	'use strict';

	angular.module('appstarter').factory('loginService', loginService);

	/** @ngInject */
	function loginService($http, config) {
		return {
			login : function(credentials) {
				var headers = {};
				if (angular.isDefined(credentials)) {
					headers = {
						"auth-token" : credentials.user + ":"
								+ credentials.password
					};
				}
				return $http.get(config.apiURL + config.secureBase + "/user", {
					headers : headers
				});
			}
		};
	}

})();