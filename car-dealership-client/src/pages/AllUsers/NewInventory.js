import React, { Component } from 'react';
import SearchInventory from '../../components/SearchInventory'


class NewInventory extends Component {
    // constructor(props) {
    //     super(props);
    //     this.state = {
    //       specials: []
    //     }
    //   }

    render() {
        return (
            <div>
                <h2>New Inventory</h2>
                <SearchInventory type="new" typeOfSearch="userSearch" />
            </div>
        );
    }
}

export default NewInventory;