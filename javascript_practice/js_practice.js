console.log('script sourced');

//Officially, JS is a prototype language. 'Big bag of keys and values'. Will store a prototypical version of our objects, creates a specific version based on the prototype that is stored in memory


//This is a safety net to protect variables from the global environment.
//But this is more of an in-browser trick. Not necessary for when we use node.
(function () {

    //Let's build a constructor for our album object!

    function Album(name, releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        // We COULD put functions on this object. But a better way to do that is to attach the function to the prototype. This means that there will be only ONE function that exists on the prototype that is available to all instances of that object. This is a much more efficient way to do this. Otherwise, if we put a function here, it will be created for every object that is created. As opposed to just one function that exists in memory. 
    }

    //For every instance that we create of Album, it's going to attach this function on the prototype of 
    Album.prototype.printIt = function () {
        console.log(this.name + ' release year is ' + this.releaseYear);
    }


    var fruit = ["apple", "starfruit", "peach"];
    var object = {
        name: 'David Bowie',
        albums: [
            { name: 'Ziggy Stardust', releaseYear: 1972 },
            { name: 'Space Oddity', releaseYear: 1974 },
            { name: 'Labyrinth Soundtrack', releaseYear: 1986 },
            //Here we're creating an album using the constructor
            new Album('hello', 123)
        ]
    };

    object.albums.forEach(function (album) {
        console.log('album', album);
    })

    //Be careful with adding stuff to objects. We can do this:
    object.thisPropertyDoesntExist = 'now it exists';
    //Now, we've added this new property to object. 

    object.albums[1].printIt = function () {
        console.log(this.name + ' release year is ' + this.releaseYear);
    }


    object['yearOfDeath'] = 2017;

    for (var key in object) {
        //Logs the keys for each thing in object (name, albums)
        console.log(key);
    }

    fruit.forEach(function (item) {
        console.log(item);
    })

    //Here's a function that will take any number of arguments: 
    function add() {
        var sum = 0;
        for (var i = 0; i < arguments.length; i++) {
            sum += arguments[i];
        }
        return sum;
    }


    //We can also call functions on objects, even if the objects don't have that function as a method.
    //Also, even if this function was officially attached to another object as a prototype method on that object, we could still actually use it on other objects, by using the method 'apply'. 

    function print() {
        console.log(this.name);
    }

    var davidBowie = {
        name: 'David Bowie'
    }

    //We would expect this to print out 'David Bowie'. This function could be applied to any object that has a name property. In the function 'print': 'this' represents whatever object the function is called with.
    print.apply(davidBowie);
    
    //And we can also do this:
    function createPrinter(arg) {
        //This is a closure. Once we're outside, we can't get at this state anymore.
        //Closes over this state
        //We could have a function at this level, and use that function in the public function, and then it would not be accessible to the outside. This helps make things more secure. (?)
        //Because the scope no longer exists
        var privateState = 'somethingPrivate';
        return function(){
            console.log(arg.name);
            console.log(privateState);
        }
    }

    var book = {name: 'Harry Potter'};

    var print = createPrinter(book);
    print();



})();