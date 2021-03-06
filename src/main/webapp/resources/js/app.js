'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    // $routeProvider.when('/cars', {
    //     templateUrl: 'cars/layout',
    //     controller: CarController
    // });
    //
    // $routeProvider.when('/trains', {
    //     templateUrl: 'trains/layout',
    //     controller: TrainController
    // });
    //
    // $routeProvider.when('/railwaystations', {
    //     templateUrl: 'railwaystations/layout',
    //     controller: RailwayStationController
    // });

    $routeProvider.when('/items', {
        templateUrl: 'items/layout',
        controller: ItemController
    });

    $routeProvider.when('/', {
        templateUrl: 'items/layout',
        controller: ItemController
    });

    $routeProvider.when('/basket', {
        templateUrl: 'basket/layout',
        controller: BasketController
    });

    $routeProvider.otherwise({redirectTo: '/items'});
}]);
