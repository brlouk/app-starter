(function() {
	'use strict';

	angular.module('appstarter').config(config);

	/** @ngInject */
	function config($logProvider, $resourceProvider, datetimepickerProvider,
			$httpProvider) {
		// Enable log
		$logProvider.debugEnabled(true);

		// REST-ngresource
		$resourceProvider.defaults.stripTrailingSlashes = false;
		// HTTP
		$httpProvider.defaults.withCredentials = true;
		$httpProvider.interceptors.push('htppInterceptor');	
	}

})();
