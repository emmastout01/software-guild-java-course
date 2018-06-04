import React, { Component } from 'react';
import FeaturedVehicle from './FeaturedVehicle';
import VehicleInSearch from './VehicleInSearch';
import AdminVehicleInSearch from './AdminVehicleInSearch';
import SalesVehicleInSearch from './SalesVehicleInSearch';

class VehicleList extends Component {
    constructor(props) {
        super(props)
        this.state = {
            vehicles: props.vehicles,
            typeOfList: props.typeOfList
        }

        this.renderVehicles = this.renderVehicles.bind(this);
    }

    renderVehicles(vehicle) {
        switch (this.state.typeOfList) {
            case "featured":
                return (
                    <li><FeaturedVehicle key={vehicle.vehicleId} vehicle={vehicle} /></li>
                )
                break;
            case "userSearch":
                return (
                    <li><VehicleInSearch vehicle={vehicle} /></li>
                )
                break;
            case "salesSearch":
                return (
                    <li><SalesVehicleInSearch vehicle={vehicle} /></li>
                )
                break;
            case "adminSearch":
                return (
                    <li><AdminVehicleInSearch vehicle={vehicle} /></li>
                )
        }
    }

    render() {
        return (
            <div>
                <ul>
                    {this.props.vehicles.map(this.renderVehicles)}
                </ul>
            </div>
        );
    }
}

export default VehicleList;