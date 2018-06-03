import React, { Component } from 'react';

class Specials extends Component {
    constructor(props) {
      super(props);
      this.state = {
        specials: []
      }
    }
  
    render() {
      return (
          <div>
              <h3>Specials</h3>
              <h4>special {this.props.specials}</h4>
              
              {/* <ul>
                {this.props.specials.map(function(special, index){
                    return <li key={ index }>{special}</li>;
                  })}
            </ul> */}
          </div>
      );
    }
  }

export default Specials;