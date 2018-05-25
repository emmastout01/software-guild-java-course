
function getNewArray() {
    fibArray = [1, 2];

    //Take the last two terms in the array, add them together, then push the next term on the end of the array
    while (fibArray[fibArray.length - 1] < 4000000) {
        var lastTerm = fibArray[fibArray.length - 1];
        var secondToLastTerm = fibArray[fibArray.length - 2];
        var newLastTerm = secondToLastTerm + lastTerm;
        fibArray.push(newLastTerm);
    }

    fibArray.pop(newLastTerm);
   

    console.log(fibArray);
    return fibArray;
}

function getSum(fibArray) {
    var sum = 0;
    
        for (var i = 0; i < fibArray.length; i++) {
            if(fibArray[i] % 2 == 0) {
                sum += fibArray[i];
            }  
        }
        return sum;
}

var fibArray = getNewArray();
console.log(fibArray);

var sum = getSum(fibArray);

console.log(sum);
