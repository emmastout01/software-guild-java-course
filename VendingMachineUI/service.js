myApp.service('service', function($http){
    var self = this;

     //GET items route
     self.getItems = function () {
        return $http.get('http://localhost:8080/items').then(function (response) {
            return response;
        }).catch(function(err) {
            alert('Could not get items');
            console.log(err);
        })
    }

    self.purchaseItem = function(moneyIn, itemId) {
        return $http.get('http://localhost:8080/money/' + moneyIn + '/item/' + itemId).then(function(response) {
            return response;
        }).catch(function(err) {
            alert('Could not purchase treat');
            console.log(err);
        })
    }
});