import React, { Component } from 'react';
import propTypes from 'prop-types'
import FeaturedVehicle from './FeaturedVehicle';
import VehicleInSearch from './VehicleInSearch';
import AdminVehicleInSearch from './AdminVehicleInSearch';
import SalesVehicleInSearch from './SalesVehicleInSearch';
import Vehicle from './Vehicle';

class VehicleList extends Component {
    static propTypes = {
        vehicleList: propTypes.array,
        typeOfList: propTypes.string
    }

    static defaultProps = {
        vehicleList: []
    }

    render() {
        const vehicles = this.props.vehicleList;
        return (
            <div>
                {vehicles.map((vehicle) => {
                    return (
                        <Vehicle data={vehicle} />
                    ) 
                })}
            </div>
        )
    }
}

export default VehicleList;