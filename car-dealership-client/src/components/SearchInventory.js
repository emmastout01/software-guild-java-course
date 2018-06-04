import React, { Component } from 'react';
import axios from 'axios';
import VehicleList from '../components/VehicleList';

class FeaturedVehicles extends Component {
    constructor(props) {
        super(props);
        this.state = {
            vehicleList: [],
            searchCriteria: {
                makeModelYear: '',
                minSalePrice: 0,
                maxSalePrice: 0,
                minYear: 0,
                maxYear: 0
            }
        }

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeFor = (propertyName) => {  
        return (event) => {
            this.setState({
                searchCriteria: {
                    ...this.state.searchCriteria,
                    [propertyName]: event.target.value
                }
            })
        }
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const criteria = this.state.searchCriteria;

        //Write a POST route for a search criteria that will return a response array of vehicles that match the criteria
        axios.post('http://localhost:8080/vehicle/' + this.props.type, criteria
        ).then(response => {
            console.log('Post was successful!', response.data);
            this.setState(this.state.vehicleList = response.data);
        }).catch(error => {
            console.log('Error with POST: ', error);
        })
        console.log('form submitted: ', this.state.searchCriteria);
        this.emptyState();
    }

    emptyState() {
        this.setState({
            searchCriteria: {
                makeModelYear: '',
                minSalePrice: 0,
                maxSalePrice: 0,
                minYear: 0,
                maxYear: 0
            }
        })
    }

    componentDidMount() {
        switch (this.props.type) {
            case "new":
                this.getNewVehicles();
                break;
            case "used":
                this.getUsedVehicles();
                break;
            case "all":
                this.getAllVehicles();
        }

    }

    getNewVehicles() {
        console.log("New");
    }

    getUsedVehicles() {
        console.log("used");
    }

    getAllVehicles() {
        console.log("all");
    }

    render() {
        const criteria = this.state.searchCriteria;
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <h2>Quick Search</h2>
                    Make, Model or Year: <input value={criteria.makeModelYear} 
                    onChange={this.handleChangeFor('makeModelYear')}  />
                    <br />
                    Minimum Price:
                    <select value={criteria.minSalePrice} onChange={this.handleChangeFor('minSalePrice')}>
                        <option value=''>No Minimum</option>
                        <option value='5000'>5,000</option>
                        <option value='6000'>6,000</option>
                        <option value='7000'>7,000</option>
                        <option value='8000'>8,000</option>
                        <option value='9000'>9,000</option>
                        <option value='10000'>10,000</option>
                        <option value='11000'>11,000</option>
                        <option value='12000'>12,000</option>
                        <option value='13000'>13,000</option>
                        <option value='14000'>14,000</option>
                        <option value='15000'>15,000</option>
                        <option value='16000'>16,000</option>
                    </select>
                    <br />
                    Maximum Price:
                    <select value={criteria.maxSalePrice} onChange={this.handleChangeFor('maxSalePrice')}>
                        <option value=''>No Maximum</option>
                        <option value='8000'>8,000</option>
                        <option value='9000'>9,000</option>
                        <option value='10000'>10,000</option>
                        <option value='11000'>11,000</option>
                        <option value='12000'>12,000</option>
                        <option value='13000'>13,000</option>
                        <option value='14000'>14,000</option>
                        <option value='15000'>15,000</option>
                        <option value='16000'>16,000</option>
                        <option value='17000'>17,000</option>
                        <option value='18000'>18,000</option>
                        <option value='19000'>19,000</option>
                        <option value='20000'>20,000</option>
                    </select>
                    
                    <br />
                    Minimum Year: 
                    <select value={criteria.minYear} onChange={this.handleChangeFor('minYear')}>
                        <option value=''>No Minimum</option>
                        <option value='2008'>2008</option>
                        <option value='2009'>2009</option>
                        <option value='2010'>2010</option>
                        <option value='2011'>2011</option>
                        <option value='2012'>2012</option>
                        <option value='2013'>2013</option>
                        <option value='2014'>2014</option>
                        <option value='2015'>2015</option>
                        <option value='2016'>2016</option>
                        <option value='2017'>2017</option>
                        <option value='2018'>2018</option>
                        <option value='2019'>2019</option>
                    </select>
                    <br />
                    Maximum Year: 
                    <select value={criteria.maxYear} onChange={this.handleChangeFor('maxYear')}>
                        <option value=''>No Maximum</option>
                        <option value='2008'>2008</option>
                        <option value='2009'>2009</option>
                        <option value='2010'>2010</option>
                        <option value='2011'>2011</option>
                        <option value='2012'>2012</option>
                        <option value='2013'>2013</option>
                        <option value='2014'>2014</option>
                        <option value='2015'>2015</option>
                        <option value='2016'>2016</option>
                        <option value='2017'>2017</option>
                        <option value='2018'>2018</option>
                        <option value='2019'>2019</option>
                    </select>
                    <br />
                    <br />
                    <input type='submit' value='Search' />
                </form >

                <VehicleList typeOfList={this.props.typeOfList} vehicles={this.state.vehicleList} />
            </div>
        );
    }
}

export default FeaturedVehicles;