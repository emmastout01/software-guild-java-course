import React, { Component, Fragment } from 'react';



class Vehicle extends Component {

    render() {
        const vehicle = this.props.vehicle;
        const typeOfList = this.props.typeOfList;

        const detailsLink = "/inventory/details/" + vehicle.vehicleId;
        const purchaseLink = "/sales/purchase/" + vehicle.vehicleId;
        const editList = "/admin/editVehicle/" + vehicle.vehicleId;

        console.log('vehicle in vehicle: ', vehicle, vehicle.vehicleId.toString());
        return (
            <Fragment>
                {vehicle ? (
                    <div key={vehicle.vehicleId.toString()}>
                        <p>{vehicle.make.make}</p>
                        <p>{vehicle.model.model}</p>
                        <p>{vehicle.color}</p>
                        { typeOfList == "userSearch" && 
                        <div><a className="btn" href={detailsLink}><button>Details</button></a></div> }
                        { typeOfList == "salesSearch" && 
                        <div>SalesSearch content</div> }
                        { typeOfList == "adminSearch" && 
                        <div>AdminSearch content</div> }
                    </div>
                ) : (
                        <div>Error: Could not get vehicles</div>
                    )}
            </Fragment>

        )
    }
}

export default Vehicle;
