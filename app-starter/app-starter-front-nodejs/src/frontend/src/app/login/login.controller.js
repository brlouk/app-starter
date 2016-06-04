(function() {
	'use strict';

	angular.module('appstarter').controller('LoginController', LoginController);

	/** @ngInject */
	function LoginController($log, $state, $sessionStorage, loginService) {
		// INIT VARS
		var vm = this;
		vm.credentials = {};
		vm.$storage = $sessionStorage;
		vm.validation = true;

		// FUNCTIONS
		vm.doLogin = function() {
			loginService.login(vm.credentials).then(function(result) {
				vm.validation = true;
				vm.$storage['principal'] = result.data;
				$state.go('home');
			}, function() {
				vm.validation = false;
			});
		}
	}
})();