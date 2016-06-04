(function() {
	'use strict';

	angular.module('appstarter').factory('userDataService', userDataService);

	/** @ngInject */
	function userDataService(userResource) {
		return {
			getUsers : function(page, size) {
				return userResource.get({
					'param1' : page,
					'param2' : size
				}).$promise;
			}
		};

	}

	angular.module('appstarter').factory('userResource', userResource);

	/** @ngInject */
	function userResource($resource, config) {
		return $resource(config.apiURL + config.restBase
				+ '/user/:param1/:param2/:param3', {
			param1 : '@param1',
			param2 : '@param2',
			param3 : '@param3'
		})
	}

})();
