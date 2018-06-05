import React, { Component, Fragment } from 'react';
import axios from 'axios';
import SalesInformation from '../../components/SalesInformation';

class Vehicle extends Component {
    constructor(props) {
        super(props);
        this.state = {
            vehicle: null,
            contactLink: null
        }
    }

    componentDidMount() {
        const { match: { params } } = this.props;
        console.log('props for details: ', this.props.match.params);

        axios.get(`http://localhost:8080/vehicle/${params.vehicleId}`)
            .then(({ data: vehicle }) => {
                console.log('vehicle', vehicle);
                this.setState({
                    vehicle: vehicle,
                    contactLink: "/contact/" + vehicle.vin
                });
            });
    }

    purchaseVehicle = (purchaseData) => {
        console.log('Purchase data to post: ', purchaseData);
        axios.post('http://localhost:8080/purchase', purchaseData
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
                Purchase Vehicle
                {vehicle ? (
                    <div>
                        <div>
                            <p>{vehicle.make.make}</p>
                            <p>{vehicle.model.model}</p>
                            <p>{vehicle.color}</p>
                        </div>
                        <SalesInformation vehicle={vehicle} onSubmit={this.purchaseVehicle} />
                    </div>
                ) : (
                        <div>Error: {errorMessage}</div>
                    )}

            </Fragment>

        )
    }
}

export default Vehicle;