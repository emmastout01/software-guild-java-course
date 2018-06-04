import React, { Component } from 'react';
import { BrowserRouter as Redirect } from 'react-router-dom';



class Vehicle extends Component {

    render() {
        const { vehicle } = this.props;

        const DetailsLink = () => {
            return (
                <Redirect to="/vehicleDetails/:vehicleId" params={{ vehicleId: vehicle.vehicleId }}>Details</Redirect>
            )
        }

        return (
                <div className="featured-vehicle-display">

                    <p>{vehicle.make.make}</p>
                    <p>{vehicle.model.model}</p>
                    <p>{vehicle.color}</p>
                    <DetailsLink />
                </div>
        );
    }
}

export default Vehicle;