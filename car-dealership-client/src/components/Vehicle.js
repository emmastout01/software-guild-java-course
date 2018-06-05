import React from 'react';


//This destructures the props...maybe
const Vehicle = ({vehicle={}}) => {
    console.log(vehicle);
    return (
        <div>Vehicle</div>
    );
}

export default Vehicle;
