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
                message: props.match.params.vin != 0 ? props.match.params.vin : '',
            }
        }

        this.handleSubmit = this.handleSubmit.bind(this);
    }

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

    handleSubmit = (event) => {
        event.preventDefault();
        const message = this.state.message;

        //Write a POST route for a contact message

        axios.post('http://localhost:8080/message', {
            name: message.name,
            email: message.email,
            phone: message.phone,
            message: message.message,

        }).then(response => {
            console.log('Post was successful!', response);
        }).catch(error => {
            console.log('Error with POST: ', error);
        })
        console.log('form submitted: ', this.state.message);
        this.emptyState();
    }

    emptyState() {
        this.setState({
            message: {
                name: '',
                email: '',
                phone: '',
                message: this.props.match.params.vin
            }
        })
    }

    render() {
        const { match: { params } } = this.props;
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <h2>Contact with vin</h2>
                    Name: <input value={this.state.message.name} onChange={this.handleChangeFor('name')} />
                    <br />
                    Email: <input value={this.state.message.email} onChange={this.handleChangeFor('email')} />
                    <br />
                    Phone: <input value={this.state.message.phone} onChange={this.handleChangeFor('phone')} />
                    <br />
                    Message: <textarea value={this.state.message.message} onChange={this.handleChangeFor('message')} />
                    <input type='submit' value='Submit' />
                </form >
            </div>
        )
    }
}

export default Contact;