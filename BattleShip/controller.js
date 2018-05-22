var myApp = angular.module('myApp', []);

myApp.controller('controller', function (service) {
    var vm = this;
    vm.message = "";
    vm.gameBoard; 
    vm.hitShip;
    vm.sunkShip;
    vm.sunkLastShip;

    vm.getBoard = function() {
        service.getBoard().then(function(response) {
            console.log("Got board", response);
            vm.gameBoard = response;
            vm.getPointCoords(response);
            console.log('here');
        })
    }

    // vm.getBoard();

    vm.makeGuess = function(point) {
        service.makeGuess(point).then(function(response) {
            vm.hitShip = response.data[0];
            vm.sunkShip = response.data[1];
            vm.sunkLastShip = response.data[2];
            vm.getBoard();
            vm.checkIfHit(point);
    })
}

    vm.checkIfHit = function(point) {
        if (vm.sunkLastShip) {
            vm.message = "You win!";
        } else if (vm.sunkShip) {
            vm.message = "You sunk a ship! Keep on looking!";
        } else if (vm.hitShip) {
            vm.message = "It's a hit!"
        } else {
            vm.message = "You missed!"
        }
    }


    vm.newGame = function() {

    }
});