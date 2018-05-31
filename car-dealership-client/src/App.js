import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';


// Page components
import Home from './pages/AllUsers/Home';
import NewInventory from './pages/AllUsers/NewInventory';
import UsedInventory from './pages/AllUsers/UsedInventory';
import Specials from './pages/AllUsers/Specials';
import Contact from './pages/AllUsers/Contact';

class App extends Component {

  componentDidMount() {
    this.getFeaturedVehicles();
  }

  getFeaturedVehicles() {
    axios.get('localhost:8080/vehicle/featured')
    
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
              <Route exact path='/' component={Home} />
              <Route path='/inventory/new' component={NewInventory} />
              <Route path='/inventory/used' component={UsedInventory} />
              <Route path='/specials' component={Specials} />
              <Route path='/contact' component={Contact} />
            </Switch>

          </div>
        </div>
      </Router>
    );
  }
}

export default App;
