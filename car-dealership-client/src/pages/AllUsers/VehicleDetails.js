import React, { Component, Fragment } from 'react';
import axios from 'axios';

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

    render() {
        const vehicle = this.state.vehicle;
        return (
            <Fragment>
                {vehicle ? (
                    <div className="container">
                        <p>{vehicle.make.make}</p>
                        <p>{vehicle.model.model}</p>
                        <p>{vehicle.color}</p>
                        <a className="btn" href={this.state.contactLink}><button>Contact Us</button></a>
                    </div>
                ) : (
                        <div className="container">Error</div>
                    )}
            </Fragment>

        )
    }
}

export default Vehicle;