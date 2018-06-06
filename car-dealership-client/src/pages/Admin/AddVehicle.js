import React, { Component, Fragment } from 'react';
import axios from 'axios';
import AddVehicleInfo from '../../components/AddVehicleInfo';

class AddVehicle extends Component {
    constructor(props) {
        super(props);
        this.state = {
            vehicle: null,
            contactLink: null
        }
    }

    AddVehicle = (vehicleData) => {
        axios.post('http://localhost:8080/vehicle', vehicleData
        ).then(response => {
            console.log('Post success!', response);
        }).catch(error => {
            console.log('Error with POST: ', error);
        })
    }

    render() {
        const vehicle = this.state.vehicle;
        const errorMessage = this.state.errorMessage;
        return (
            <Fragment>
                <div>
                    <AddVehicleInfo onSubmit={this.addVehicle} />
                </div>
            </Fragment>

        )
    }
}

export default AddVehicle;