(function() {
	'use strict';

	angular.module('appstarter').controller('UserController', UserController);

	/** @ngInject */
	function UserController(userDataService, $log) {
		var vm = this;

		// PAGINATION
		vm.pageSize = 10;
		vm.totalItems = 0;
		vm.currentPage=1;
		vm.users = {};

		// SEARCH
		vm.search = {};

		vm.doSearch = function() {
			userDataService.getUsers(vm.currentPage - 1, vm.pageSize).then(function(result) {
				vm.users = {};
				vm.users = result.body;
				vm.totalItems = result.headers.count[0];
			}, function(error) {
				$log.debug(error);
			});
		};

		// RESET SEARCH FORM
		vm.reset = function() {
			vm.search = {};
		};

		// INIT PAGE
		activate();

		function activate() {
			// DO SEARCH
			vm.doSearch();
		}

		// PAGE CHANGED
		vm.pageChanged = function() {
			// DO SEARCH FOR THE NEXT PAGE
			vm.doSearch();

		};
	}
})();
