myApp.service('service', function ($http) {
    var self = this;

    self.getBoard = function() {
        return $http.get('http://localhost:8080/myHits').then(function(response) {
            return response;
        }).catch(function(err) {
            alert('Could not get board');
            console.log('Error with get board: ', err);
        })
    }
    
    });