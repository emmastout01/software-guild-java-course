var myApp = angular.module('myApp', []);

myApp.controller('controller', function (service) {
    var vm = this;
    vm.message = "";
    vm.gameBoard; 

    vm.getBoard = function() {
        service.getBoard().then(function(response) {
            console.log("Got board", response);
            vm.gameBoard = response;
        })
    }

    vm.getBoard();
    
    vm.makeGuess = function(point) {
        console.log(point);
    }
});