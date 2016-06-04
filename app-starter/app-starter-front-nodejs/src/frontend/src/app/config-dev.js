(function() {
  'use strict';
  
angular.module("appstarter")
.constant("config", {
	"apiURL": "http://localhost:8080/app-starter-services/",
	"restBase": "ws/rest",
	"secureBase": "secure"
})

})();