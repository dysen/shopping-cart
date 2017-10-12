'use strict';

/**
 * ItemController
 * @constructor
 */
var BasketController = function($scope, $http, $route) {
    $scope.rs = {};

    $scope.fetchBasket = function() {
        $http.get('basket/current').success(function(basket){
            $scope.basket = basket;
            console.log("basket is ok")
            console.log(basket.message)
        });
    };


    $scope.removeItem = function(rs) {

        $http.post('basket/remove', rs).success(function () {
            console.log("Removed item from basket")
            this.$route.reload();
        }).error(function () {
            //$scope.setError('Could not add item to basket');
        });
        ////fetchBasket();
        $route.reload();
        // $window.location.reload();
        // $state.reload()

    };


    // $scope.addItem = function(rs) {
    //
    //
    //
    //     $http.post('items/add', rs).success(function() {
    //         console.log("Added item to basket")
    //     }).error(function() {
    //         //$scope.setError('Could not add item to basket');
    //     });
    // };


    //ng-click="addItem(item)"
    $scope.fetchBasket();
};