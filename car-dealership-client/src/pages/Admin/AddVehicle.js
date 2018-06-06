import React, { Component, Fragment } from 'react';
import axios from 'axios';
import AddVehicleInfo from '../../components/AddVehicleInfo';

class AddVehicle extends Component {
    addVehicle = (vehicleData) => {
        axios.post('http://localhost:8080/vehicle', vehicleData
        ).then(response => {
            console.log('Post success!', response);
        }).catch(error => {
            console.log('Error with POST: ', error);
        })
    }

    render() {
        return (
            <Fragment>
                <div>
                    <h2>Add Vehicle</h2>
                    <AddVehicleInfo onSubmit={this.addVehicle} />
                </div>
            </Fragment>

        )
    }
}

export default AddVehicle;