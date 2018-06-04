import React, { Component } from 'react';
import axios from 'axios';

class Vehicle extends Component {
    constructor(props) {
        super(props);
        this.state = {
            vehicle: null
        }
    }

    componentDidMount() {
        const { match: { params } } = this.props;
        console.log('props for details: ', this.props.match.params);

        axios.get(`http://localhost:8080/vehicle/${params.vehicleId}`)
            .then(({ data: vehicle }) => {
                console.log('vehicle', vehicle);
                this.setState({ vehicle });
            });
    }

    render() {
        const vehicle = this.state.vehicle;
        const contactLink = "/contact";

        if (vehicle != null) {
            const contactLink = "/contact/" + vehicle.vin;
            return (
                <div>
                    <p>{vehicle.make.make}</p>
                    <p>{vehicle.model.model}</p>
                    <p>{vehicle.color}</p>
                    {/* Here I want to link to contact info, but also pass in the vehicle as props to the contact component */}
                    <a className="btn" href={contactLink}><button>Contact Us</button></a>
                </div>
            )
        }
        else {
            return (
                <div>Could not get vehicle</div>
            )
        }
    }
}

export default Vehicle;