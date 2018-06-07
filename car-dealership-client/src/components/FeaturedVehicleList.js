import React, { Component } from 'react';
import axios from 'axios';
import FeaturedVehicle from './FeaturedVehicle';


class FeaturedVehicleList extends Component {

  render() {
    const vehicles = this.props.vehicles;
    return (
      <div>
        <h2> Featured Vehicles </h2>
        {vehicles.map((vehicle) => {
          return (
            <FeaturedVehicle vehicle={vehicle} />
          )
        })}
      </div>
    );
  }
}

export default FeaturedVehicleList;
