(function() {
	'use strict';

	angular.module('appstarter').run(runBlock);

	/** @ngInject */
	function runBlock($log, $http, $cookies, $rootScope,$state,authService) {
		$rootScope.$on('$stateChangeStart', function(event, toState) {
			authService.authorize(toState.data.requireLogin,event);			
		})
	}

})();
