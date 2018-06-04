import React, { Component } from 'react';


class Vehicle extends Component {

    render() {
        const { vehicle } = this.props;
        const purchaseLink = "/sales/purchase/" + vehicle.vehicleId;

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
                <a className="button" href={purchaseLink}><button>Purchase</button></a>
            </div>
        );
    }
}

export default Vehicle;