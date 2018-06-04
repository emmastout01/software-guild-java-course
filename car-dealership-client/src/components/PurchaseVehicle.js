import React, { Component } from 'react';
import { BrowserRouter as Redirect } from 'react-router-dom';



class Vehicle extends Component {

    render() {
        const { vehicle } = this.props;

        return (
                <div className="featured-vehicle-display">

                {/*     <p>{vehicle.make.make}</p>
                   <p>{vehicle.model.model}</p>
                   <p>{vehicle.color}</p>
                <a className="button" href={detailsLink}>Details</a> */}
                </div>
        );
    }
}

export default Vehicle;