import React, { Component } from 'react';
import SearchInventory from '../../components/SearchInventory';
import axios from 'axios';
import VehicleList from '../../components/VehicleList';


class NewInventory extends Component {
    state = {
        vehicleList: [],
    }

    getVehicles = (criteria) => {
        console.log('criteria in parent component: ', criteria);
        axios.post('http://localhost:8080/vehicle/new', criteria
        ).then(response => {
            console.log(response.data);
            this.setState(this.state.vehicleList = response.data);
        }).catch(error => {
            console.log('Error with POST: ', error);
        })
    }

    render() {
        return (
            <div>
                <h2>New Inventory</h2>
                <SearchInventory onSubmit={this.getVehicles} type="new" typeOfSearch="userSearch" />
                <VehicleList vehicleList={this.state.vehicleList} typeOfList="userSearch" />
            </div>
        );
    }
}

export default NewInventory;