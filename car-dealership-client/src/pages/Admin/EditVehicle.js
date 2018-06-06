import React, { Component, Fragment } from 'react';
import axios from 'axios';
import AddVehicleInfo from '../../components/AddVehicleInfo';

class EditVehicle extends Component {
    state = {
        vehicle: null,
        errorMessage: null
    }

    componentDidMount() {
        const { match: { params } } = this.props;
        console.log('props for details: ', this.props.match.params);

        axios.get(`http://localhost:8080/vehicle/${params.vehicleId}`)
            .then(({ data: vehicle }) => {
                console.log('vehicle', vehicle);
                this.setState({
                    vehicle: vehicle,
                });
            });
    }

    editVehicle = (vehicleData) => {
        const { match: { params } } = this.props;
        console.log('vehicle to send: ', vehicleData);
        axios.put(`http://localhost:8080/vehicle/${params.vehicleId}`, vehicleData
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
                <h2>Edit Vehicle</h2>
                {vehicle ? (
                    <div>
                        <AddVehicleInfo vehicle={vehicle} onSubmit={this.editVehicle} />
                    </div>
                ) : (
                        <div>Error: {errorMessage}</div>
                    )}

            </Fragment>

        )
    }
}

export default EditVehicle;