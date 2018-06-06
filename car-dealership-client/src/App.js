import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import axios from 'axios';


// Page components
import Home from './pages/AllUsers/Home';
import NewInventory from './pages/AllUsers/NewInventory';
import UsedInventory from './pages/AllUsers/UsedInventory';
import Specials from './pages/AllUsers/Specials';
import Contact from './pages/AllUsers/Contact';
import VehicleDetails from './pages/AllUsers/VehicleDetails';
import PurchaseVehicle from './pages/Sales/PurchaseVehicle';
import SalesSearch from './pages/Sales/SalesSearch';
import AdminSearch from './pages/Admin/AdminVehicleSearch';
import EditVehicle from './pages/Admin/EditVehicle';
import AddVehicle from './pages/Admin/AddVehicle';

class App extends Component {

  render() {
    return (
      <Router>
        <div className="App">
          <div className="container">
            <div className="menu-bar">
              <ul>
                <li>
                  <Link to='/'>Home</Link>
                </li>
                <li>
                  <Link to='/inventory/new'>New Inventory</Link>
                </li>
                <li>
                  <Link to='/inventory/used'>Used Inventory</Link>
                </li>
                <li>
                  <Link to='/specials'>Specials</Link>
                </li>
                <li>
                  <Link to='/contact/0'>Contact</Link>
                </li>
              </ul>
            </div>

            <hr />

            <Switch>
              <Route exact path='/' component={Home} />
              <Route path='/inventory/new' component={NewInventory} />
              <Route path='/inventory/used' component={UsedInventory} />
              <Route path='/specials' component={Specials} />
              <Route path='/contact/:vin' component={Contact} />
              <Route path='/inventory/details/:vehicleId' 
              component={VehicleDetails} />
              <Route path='/sales/index' component={SalesSearch} />
              <Route path='/sales/purchase/:vehicleId' component={PurchaseVehicle} />
              <Route path='/admin/index' component={AdminSearch} />
              {/* <Route path='/admin/editVehicle/:vehicleId' component={EditVehicle} /> */}
              <Route path='/admin/addVehicle' component={AddVehicle} />
            </Switch>

          </div>
        </div>
      </Router>
    );
  }
}

export default App;
