var myApp = angular.module('myApp', []);

myApp.controller('controller', function (service) {
    var vm = this;
    vm.service = service;
    vm.items = [];
    vm.moneyUnfixed = 0;
    vm.moneyInMachine;
    vm.itemId;
    vm.message = "";
    vm.change;

    vm.getTreats = function () {
        vm.service.getItems().then(function (response) {
            console.log('got items: ', response.data);
            vm.items = response.data;
        })
    }

    vm.getTreats();


    vm.addMoney = function (moneyIn) {
        vm.moneyUnfixed += moneyIn;
        vm.moneyInMachine = vm.moneyUnfixed.toFixed(2);
    }

    vm.getItemId = function(itemId) {
        vm.itemId = itemId;
        console.log(vm.itemId);
    }

    vm.purchaseItem = function(moneyIn, itemId) {
        vm.service.purchaseItem(moneyIn, itemId).then(function(response) {
            if (response.data.message != null) {
                vm.message = response.data.message;
            } else {
                vm.message = "Thank you!";
            }
            vm.change = {
                quarters: response.data.quarters,
                dimes: response.data.dimes,
                nickels: response.data.nickels,
                pennies: response.data.pennies
            }
            vm.moneyInMachine = 0;
            vm.itemId = null;
            vm.getTreats();
        })
    }





});

