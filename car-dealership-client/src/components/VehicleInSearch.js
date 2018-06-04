import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';



class Vehicle extends Component {

    // getVehicleDetails(vehicleId) {
    //     //Here, I want to route to a new page, VehicleDetails, that will have access to all details of the vehicle with this id
    //     window.location = '/i'
        
    //     return (
    //         <li><FeaturedVehicle vehicle={vehicle} /></li>
    //     )
    // }
    // handleSearch: function() {
    //     window.location = '/search/'+this.state.query+'/some-action';
    //   }

    render() {
        const { vehicle } = this.props;

        return (
  
            <div className="vehicle-search-display">
                <p><strong>{vehicle.year} {vehicle.make.make}
                  {vehicle.model.model}</strong></p>
                <p><strong>Body Style: </strong>{vehicle.bodyStyle}</p>
                <p><strong>Trans: </strong>{vehicle.transmission}</p> 
                <p><strong>Color: </strong>{vehicle.color}</p> 
                <p><strong>Interior: </strong>{vehicle.interior}</p> 
                <p><strong>Mileage: </strong>{vehicle.mileage}</p> 
                <p><strong>VIN: </strong>{vehicle.vin}</p> 
                <p><strong>Sale Price: </strong>{vehicle.salePrice}</p> 
                <p><strong>MSRP: </strong>{vehicle.msrp}</p>  
                {/* On the click of this button, I want to pass in the vehicle id and I want to jump to displaying the vehicle details page */}
                {/* <button onClick={(e) => this.getVehicleDetails(vehicle.vehicleId, e)}>Details</button> */}
                {/* <button onClick={this.handleSearch()} className="button">
          Search
        </button> */}
                <Link to="/vehicleDetails/:vehicleId" params={{ vehicleId: vehicle.vehicleId}}>Details</Link>    
            </div>
    
        );
    }
}

export default Vehicle;