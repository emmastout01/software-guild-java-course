import React, { Component } from 'react';
import axios from 'axios';
import VehicleList from '../../../components/VehicleList';

class FeaturedVehicles extends Component {
    constructor(props) {
      super(props);
      this.state = {
        featuredVehicles: []
      }
    }
  
    componentDidMount() {
        this.getFeaturedVehicles();
      }
    
      //THis is where I want the get request, then pass in the data as props into the vehicle list
      getFeaturedVehicles() {
        axios.get('http://localhost:8080/vehicle/featured')
        .then(response => {
            this.setState(this.state.featuredVehicles = response.data);
            console.log(response.data);
        }).catch(error => {
          console.log(error);
        })
        
      }

  
    render() {
      return (
          <div>
              <VehicleList typeOfList="userSearch" vehicles={this.state.featuredVehicles}/>
          </div>
      );
    }
  }

export default FeaturedVehicles;
