import React, { Component } from 'react';
import Featured from './FeaturedVehicles';
import Specials from './Specials';

class Home extends Component {
    // constructor(props) {
    //     super(props);
    //     this.state = {
    //       specials: []
    //     }
    //   }

    render() {
        return (
            <div>
        <h2>Home</h2>
        <Specials />
        <h3>Featured Vehicles</h3>
        <Featured />
    </div>
        );
      }
}

export default Home;