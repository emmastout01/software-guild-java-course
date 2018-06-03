import React, { Component } from 'react';


    class Vehicle extends Component {
        
        render() {
            const {vehicle} = this.props;

            return (
                <div className="featured-vehicle-display">
                    
                    <p>{vehicle.make.make}</p>
                    <p>{vehicle.model.model}</p>
                    <p>{vehicle.color}</p>
                </div>
            );
        }
    }

export default Vehicle;