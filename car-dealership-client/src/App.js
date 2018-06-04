import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import axios from 'axios';


// Page components
import Home from './pages/AllUsers/Home/Home';
import NewInventory from './pages/AllUsers/NewInventory';
import UsedInventory from './pages/AllUsers/UsedInventory';
import Specials from './pages/AllUsers/Specials';
import Contact from './pages/AllUsers/Contact';
import VehicleDetails from './components/VehicleDetails';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      specials: []
    }
  }

  componentDidMount() {
    this.getSpecials();
  }

  getSpecials() {
    axios.get('http://localhost:8080/special/all')
    .then(response => {
    }).catch(error => {
      console.log(error);
    })
  }

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
                  <Link to='/contact'>Contact</Link>
                </li>
              </ul>
            </div>

            <hr />

            <Switch>
              <Route exact path='/' component={Home} specials={this.state.specials}/>
              <Route path='/inventory/new' component={NewInventory} />
              <Route path='/inventory/used' component={UsedInventory} />
              <Route path='/specials' component={Specials} />
              <Route path='/contact' component={Contact} />
              <Route name="vehicleDetails" path='/inventory/:vehicleId' 
              component={VehicleDetails} />
            </Switch>

          </div>
        </div>
      </Router>
    );
  }
}

export default App;
