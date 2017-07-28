angular.module('CrudApp').factory('StudentUser', StudentUser);
 
StudentUser.$inject = [ '$resource' ];
 
function StudentUser($resource) {
	var resourceUrl = '/api/studentUser/:id';
 
	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}