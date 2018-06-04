import React, { Component } from 'react';
import axios from 'axios';

    class Vehicle extends Component {
        constructor(props) {
            super(props);
            this.state = {
              vehicle: {
                  make: {
                      make: 'hello'
                  },
                  model: {
                      model: 'world'
                  },
                  color: 'test'
                  
              }
            }
          }
        
        componentDidMount() {
            const { match: { params } } = this.props;
          
            axios.get(`http://localhost:8080/vehicle/${params.vehicleId}`)
              .then(({ data: vehicle }) => {
                console.log('vehicle', vehicle);
          
                this.setState({ vehicle });
              });
          }

        render() {
            const vehicle = this.state.vehicle;

            return (
                <div>
                    
                    <p>{vehicle.make.make}</p>
                    <p>{vehicle.model.model}</p>
                    <p>{vehicle.color}</p>
                </div>
            );
        }
    }

export default Vehicle;