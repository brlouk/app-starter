(function() {
	'use strict';

	angular.module('appstarter').directive('appNavbar', appNavbar);

	/** @ngInject */
	function appNavbar() {
		var directive = {
			restrict : 'E',
			templateUrl : 'app/components/navbar/navbar.html',
			scope : {

			},
			controller : NavbarController,
			controllerAs : 'nav',
			bindToController : true
		};

		return directive;

		/** @ngInject */
		function NavbarController($log, $state, $sessionStorage, authService) {
			var vm = this;
			vm.logout = function() {
				authService.invalidateSession();
			}
		}
	}

})();
