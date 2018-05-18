var myApp = angular.module('myApp', []);

myApp.controller('controller', function (service) {
    var vm = this;
    vm.service = service;
    vm.items = [];
    vm.moneyUnfixed = 0;
    vm.moneyInMachine = 0;
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

    vm.getItemId = function (itemId) {
        vm.itemId = itemId;
        console.log(vm.itemId);
    }

    vm.purchaseItem = function (moneyIn, itemId) {
        vm.service.purchaseItem(moneyIn, itemId).then(function (response) {
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

    vm.returnChange = function () {
        var amountToSubtract = 0;
        var amountInPennies = vm.moneyInMachine * 100;
        var quarters = 0;
        var dimes = 0;
        var nickels = 0;
        var pennies = 0;

        quarters = Math.floor(amountInPennies / 25);
        amountToSubtract = quarters * 25;
        amountInPennies = amountInPennies - amountToSubtract;

        dimes = Math.floor(amountInPennies / 10);
        amountToSubtract = dimes * 10;
        amountInPennies = amountInPennies - amountToSubtract;

        nickels = Math.floor(amountInPennies / 5);
        amountToSubtract = nickels * 5;
        amountInPennies = amountInPennies - amountToSubtract;

        vm.change = {
            quarters: quarters,
            dimes: dimes,
            nickels: nickels,
            pennies: pennies
        }

        vm.message = "";
        vm.itemId = null;
        vm.moneyInMachine = 0;
        vm.moneyUnfixed = 0;
    }





});

