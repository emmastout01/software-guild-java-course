var myApp = angular.module('myApp', []);

myApp.controller('controller', function(service) {
    var vm = this;
    vm.service = service;

    vm.items = [];

    vm.getTreats = function() {
        vm.service.getItems().then(function(response) {
            console.log('got items: ', response.data);
            vm.items = response.data;
        })
    }

    vm.getTreats();

    



});

