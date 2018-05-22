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

    self.makeGuess = function(point) {
        return $http.put('http://localhost:8080/myHits/' + point).then(function(response) {
            return response;
        }).catch(function(err) {
            alert('Could not fire hit');
            console.log('Error with make guess: ', err);
        })
    }
    
    });