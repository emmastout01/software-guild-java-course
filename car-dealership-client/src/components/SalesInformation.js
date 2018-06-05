import React, { Component } from 'react';
import propTypes from 'prop-types';

class SalesInformation extends Component {
    static propTypes = {
        onSubmit: propTypes.func,
        vehicle: propTypes.object
    }

    state = {
        purchaseData: {
            name: '',
            phone: '',
            email: '',
            street1: '',
            street2: '',
            city: '',
            state: 'AL',
            zipCode: '',
            purchasePrice: 0,
            purchaseType: 'Bank Finance',
            user: {
                userId: 1
            },
            vehicle: {
                vehicleId: this.props.vehicle.vehicleId
            }
        }

    }

    handleChangeFor = (propertyName) => {

        return (event) => {
            this.setState({
                purchaseData: {
                    ...this.state.purchaseData,
                    [propertyName]: event.target.value
                }
            })
        }
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const purchaseData = this.state.purchaseData;
        console.log(purchaseData);
        this.props.onSubmit(purchaseData);
        this.emptyState();
    }

    emptyState() {
        this.setState({
            purchaseData: {
                name: '',
                phone: '',
                email: '',
                street1: '',
                street2: '',
                city: '',
                state: 'AL',
                zipCode: '',
                purchasePrice: 0,
                purchaseType: 'Bank Finance',
                user: {
                    userId: 1
                },
                vehicle: {
                    vehicleId: this.props.vehicle.vehicleId
                }
            }
        })
    }

    render() {
        const purchaseData = this.state.purchaseData;
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <h2>Purchase Vehicle</h2>
                    Name: <input value={purchaseData.name}
                        onChange={this.handleChangeFor('name')} />
                    <br />
                    Phone: <input value={purchaseData.phone}
                        onChange={this.handleChangeFor('phone')} />
                    <br />
                    Email: <input value={purchaseData.email}
                        onChange={this.handleChangeFor('email')} />
                    <br />
                    Street 1: <input value={purchaseData.street1}
                        onChange={this.handleChangeFor('street1')} />
                    <br />
                    Street 2: <input value={purchaseData.street2}
                        onChange={this.handleChangeFor('street2')} />
                    <br />
                    City: <input value={purchaseData.city}
                        onChange={this.handleChangeFor('city')} />
                    <br />
                    State:  <select value={purchaseData.state} onChange={this.handleChangeFor('state')}>
                        <option value="AL">AL</option>
                        <option value="AK">AK</option>
                        <option value="AZ">AZ</option>
                        <option value="AR">AR</option>
                        <option value="CA">CA</option>
                        <option value="CO">CO</option>
                        <option value="CT">CT</option>
                        <option value="DE">DE</option>
                        <option value="DC">DC</option>
                        <option value="FL">FL</option>
                        <option value="GA">GA</option>
                        <option value="HI">HI</option>
                        <option value="ID">ID</option>
                        <option value="IL">IL</option>
                        <option value="IN">IN</option>
                        <option value="IA">IA</option>
                        <option value="KS">KS</option>
                        <option value="KY">KY</option>
                        <option value="LA">LA</option>
                        <option value="ME">ME</option>
                        <option value="MD">MD</option>
                        <option value="MA">MA</option>
                        <option value="MI">MI</option>
                        <option value="MN">MN</option>
                        <option value="MS">MS</option>
                        <option value="MO">MO</option>
                        <option value="MT">MT</option>
                        <option value="NE">NE</option>
                        <option value="NV">NV</option>
                        <option value="NH">NH</option>
                        <option value="NJ">NJ</option>
                        <option value="NM">NM</option>
                        <option value="NY">NY</option>
                        <option value="NC">NC</option>
                        <option value="ND">ND</option>
                        <option value="OH">OH</option>
                        <option value="OK">OK</option>
                        <option value="OR">OR</option>
                        <option value="PA">PA</option>
                        <option value="RI">RI</option>
                        <option value="SC">SC</option>
                        <option value="SD">SD</option>
                        <option value="TN">TN</option>
                        <option value="TX">TX</option>
                        <option value="UT">UT</option>
                        <option value="VT">VT</option>
                        <option value="VA">VA</option>
                        <option value="WA">WA</option>
                        <option value="WV">WV</option>
                        <option value="WI">WI</option>
                        <option value="WY">WY</option>
                    </select>
                    <br />
                    Zip Code: <input value={purchaseData.zipCode}
                        onChange={this.handleChangeFor('zipCode')} />
                    <br />
                    Purchase Price: <input value={purchaseData.purchasePrice}
                        onChange={this.handleChangeFor('purchasePrice')} />
                    <br />
                    Purchase Type: <select value={purchaseData.purchaseType}
                        onChange={this.handleChangeFor('purchaseType')}>
                        <option value="Bank Finance">Bank Finance</option>
                        <option value="Cash">Cash</option>
                        <option value="Dealer Finance">Dealer Finance</option>
                    </select>
                    <br />
                    <input type='submit' value='Save' />
                </form >
            </div>
        );
    }
}

export default SalesInformation;