var app = angular.module('CrudApp', ['ngResource']);
angular.module("CrudApp").controller("GeneralController", GeneralController);

GeneralController.inject = [ '$scope', 'StudentUser'];
 
function GeneralController($scope, StudentUser) {
	
	$scope.studentUsers = StudentUser.query(); 
	$scope.studentUser = {};	 
	
	$scope.savestudentUser = function() {
		if ($scope.studentUser.id !== undefined) {
			StudentUser.update($scope.studentUser, function() {
				$scope.studentUsers = StudentUser.query();
				$scope.studentUser = {};
			});
		} else {
			StudentUser.save($scope.studentUser, function() {
				$scope.studentUsers = StudentUser.query();
				$scope.studentUser = {};
			});
		}
	}
 
	$scope.updateStudentUserInit = function(studentUser) {
		$scope.studentUser = studentUser;
	}
 
	$scope.deleteStudentUser = function(studentUser) {
		studentUser.$delete({id: studentUser.id}, function() {
			$scope.studentUsers = StudentUser.query();
		});
	}
	//This is for exit sync text field by update function
	$scope.confirmupdate = function(studentUser) {
		$scope.studentUser = {};
	}
	//hide confirm button for use only with update function
	$scope.hide_ok = true;
	
	$scope.btn_hide = function() {
		$scope.hide_ok = true;
	}
	$scope.btn_show = function() {
		$scope.hide_ok = false;
	}
}