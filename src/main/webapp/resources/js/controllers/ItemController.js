'use strict';

/**
 * ItemController
 * @constructor
 */
var ItemController = function($scope, $http) {
    $scope.rs = {};

    $scope.fetchItemList = function() {
        $http.get('items/itemlist.json').success(function(itemList){
            $scope.items = itemList;
            console.log("olololo")
            console.log(itemList.length)
        });
    };

    $scope.addItem = function(rs) {



        $http.post('items/add', rs).success(function() {
            console.log("Added item to basket")
        }).error(function() {
            //$scope.setError('Could not add item to basket');
        });
    };




$scope.fetchItemList();
};