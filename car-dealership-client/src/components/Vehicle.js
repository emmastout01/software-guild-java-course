import React, { Component, Fragment } from 'react';



class Vehicle extends Component {

    render() {
        const vehicle = this.props.vehicle;
        const typeOfList = this.props.typeOfList;

        const detailsLink = "/inventory/details/" + vehicle.vehicleId;
        const purchaseLink = "/sales/purchase/" + vehicle.vehicleId;
        const editLink = "/admin/editVehicle/" + vehicle.vehicleId;

        return (
            <Fragment>
                {vehicle ? (
                    <div key={vehicle.vehicleId.toString()}>
                            <p><strong>{vehicle.year} {vehicle.make.make} {vehicle.model.model}</strong></p>
                          <p><strong>Body Style: </strong>{vehicle.bodyStyle}</p>
                          <p><strong>Trans: </strong>{vehicle.transmission}</p> 
                          <p><strong>Color: </strong>{vehicle.color}</p> 
                          <p><strong>Interior: </strong>{vehicle.interior}</p> 
                          <p><strong>Mileage: </strong>{vehicle.mileage}</p> 
                          <p><strong>VIN: </strong>{vehicle.vin}</p> 
                          <p><strong>Sale Price: </strong>{vehicle.salePrice}</p> 
                          <p><strong>MSRP: </strong>{vehicle.msrp}</p>  
                        { typeOfList == "userSearch" && 
                        <div><a className="btn-primary" href={detailsLink}><button>Details</button></a></div> }
                        { typeOfList == "salesSearch" && 
                        <div><a className="btn-primary" href={purchaseLink}><button>Purchase</button></a></div> }
                        { typeOfList == "adminSearch" && 
                        <div><a className="btn-primary" href={editLink}><button>Edit</button></a></div> }
                    </div>
                ) : (
                        <div>Error: Could not get vehicles</div>
                    )}
            </Fragment>

        )
    }
}

export default Vehicle;
