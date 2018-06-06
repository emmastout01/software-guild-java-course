import React, { Component } from 'react';
import propTypes from 'prop-types';
import axios from 'axios';

class AddVehicleInfo extends Component {
    state = {
        vehicleData: {
            make: '',
            model: '',
            type: '',
            bodyStyle: '',
            year: '',
            transmission: '',
            color: '',
            interior: '',
            mileage: 0,
            vin: '',
            msrp: 0,
            salePrice: 0,
            description: '',
            photo: ''
        },
        makes: [],
        models: []
    }

    static propTypes = {
        onSubmit: propTypes.func,
    }

    componentDidMount() {
        this.getMakes();
        this.getModels();
    }

    getMakes() {
        axios.get('http://localhost:8080/make/all')
            .then(response => {
                console.log('make response: ', response);
                this.setState({ 
                    makes: response.data
                })
            }).catch(error => {
                console.log(error);
            })
    }

    getModels() {
        axios.get('http://localhost:8080/model/all')
            .then(response => {
                console.log('model response: ', response);
                this.setState({ 
                    models: response.data
                })
            }).catch(error => {
                console.log(error);
            })
    }

    handleChangeFor = (propertyName) => {

        return (event) => {
            this.setState({
                vehicleData: {
                    ...this.state.vehicleData,
                    [propertyName]: event.target.value
                }
            })
        }
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const vehicleData = this.state.vehicleData;
        this.props.onSubmit(vehicleData);
        this.emptyState();
    }

    emptyState() {
        this.setState({
            vehicleData: {
                make: '',
                model: '',
                type: '',
                bodyStyle: '',
                year: '',
                transmission: '',
                color: '',
                interior: '',
                mileage: 0,
                vin: '',
                msrp: 0,
                salePrice: 0,
                description: '',
                photo: ''
            }
        })
    }

    render() {
        const vehicleData = this.state.vehicleData;
        const makes = this.state.makes;
        const models = this.state.models;
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <h2>Add Vehicle</h2>

                    Make: <select value={vehicleData.make}
                        onChange={this.handleChangeFor('make')}>
                        <option>Select Make</option>
                        {makes.map((make) => {
                            return (
                                <option value={make.make}>{make.make}</option>
                            )
                        })}
                    </select>
                    <br />

                    Model: <select value={vehicleData.model}
                        onChange={this.handleChangeFor('model')}>
                        {models.filter((model) => {
                            console.log('model make: ', model.make.make);
                            console.log('make : ', this.state.vehicleData.make);
                            return (model.make.make == this.state.vehicleData.make);
                        }).map((model) => {
                            return (
                                <option value={model.model}>{model.model}</option>
                            )
                        })}
                    </select>
                    <br />

                    Type: <select value={vehicleData.type}
                        onChange={this.handleChangeFor('type')}>
                        <option value="New">New</option>
                        <option value="Used">Used</option>
                    </select>
                    <br />

                    Body Style: <select value={vehicleData.bodyStyle}
                        onChange={this.handleChangeFor('bodyStyle')}>
                        <option value="Car">Car</option>
                        <option value="SUV">SUV</option>
                        <option value="Truck">Truck</option>
                        <option value="Van">Van</option>
                    </select>
                    <br />


                    Year: <input value={vehicleData.year}
                        onChange={this.handleChangeFor('year')} />
                    <br />

                    Transmission: <select value={vehicleData.transmission}
                        onChange={this.handleChangeFor('transmission')}>
                        <option value="Manual">Manual</option>
                        <option value="Automatic">Automatic</option>
                    </select>
                    <br />

                    Color: <select value={vehicleData.color}
                        onChange={this.handleChangeFor('color')}>
                        <option value="Red">Red</option>
                        <option value="Yellow">Yellow</option>
                        <option value="Blue">Blue</option>
                        <option value="Black">Black</option>
                        <option value="Silver">Silver</option>
                        <option value="White">White</option>
                    </select>
                    <br />

                    Interior: <select value={vehicleData.interior}
                        onChange={this.handleChangeFor('interior')}>
                        <option value="Black">Black</option>
                        <option value="Silver">Beige</option>
                        <option value="White">Burgundy</option>
                    </select>
                    <br />

                    Mileage: <input value={vehicleData.mileage}
                        onChange={this.handleChangeFor('mileage')} />
                    <br />
                    VIN: <input value={vehicleData.vin}
                        onChange={this.handleChangeFor('vin')} />
                    <br />
                    MSRP: <input value={vehicleData.msrp}
                        onChange={this.handleChangeFor('msrp')} />
                    <br />
                    Sale Price: <input value={vehicleData.salePrice}
                        onChange={this.handleChangeFor('salePrice')} />
                    <br />
                    Description: <textarea value={vehicleData.description}
                        onChange={this.handleChangeFor('description')} />
                    <br />
                    <input type='submit' value='Save' />
                </form >
            </div>
        );
    }
}

export default AddVehicleInfo;