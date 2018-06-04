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
              <VehicleList typeOfList="featured" vehicles={this.state.featuredVehicles}/>
          </div>
      );
    }
  }

export default FeaturedVehicles;
