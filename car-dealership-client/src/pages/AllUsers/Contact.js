import React, { Component } from 'react';
import axios from 'axios';


class Contact extends Component {
    constructor(props) {
        super(props);
        this.state = {
            message: {
                name: '',
                email: '',
                phone: '',
                message: '',
            }
        }
    }


    // componentDidMount() {
    //     const { match: { params } } = this.props;

    //     //Write a POST route for a contact message

    //     axios.post('http://localhost:8080/message', {
    //         name:
    //         email: 
    //         phone:
    //         message:   

    //     }, config)

    // }

    // handleInputChange(event) {
    //     this.setState({
    //         message: {
    //             ...this.state.message,

    //         }
    //     })
    // }

    //Currying: Returns a function
    handleChangeFor = (propertyName) => {
        return (event) => {
            console.log(event.target.value);
            this.setState({
                message: {
                    ...this.state.message,
                    [propertyName]: event.target.value

                }
            })
        }
    }

    render() {
        const { match: { params } } = this.props;

        if (params.vin == 0) {
            return (
                <div>
                    <h2>Contact, no vin</h2>
                </div>

            )
        }
        else {
            return (
                <div>
                    <h2>Contact with vin</h2>
                    Name: <input onChange={this.handleChangeFor('name')} />
                    <br />
                    Email: <input onChange={this.handleChangeFor('email')} />
                    <br />
                    Phone: <input onChange={this.handleChangeFor('phone')} />
                    <br />
                    Message: <textarea onChange={this.handleChangeFor('name')} defaultValue={params.vin} />
                    
            </div>
            )
        }

    }
}

export default Contact;