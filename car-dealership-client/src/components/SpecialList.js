import React, { Component } from 'react';
import Special from './Special';

class SpecialList extends Component {

    render() {
        const specials = this.props.specials;
        return (
            <div>
                <div className="carousel slide" data-ride="carousel">
                    <div className="carousel-inner">
                        <div className="carousel-item active">
                            <h1>Hello world</h1>
                        </div>
                        <div className="carousel-item">
                            <img className="d-block w-100" src=".../800x400?auto=yes&bg=666&fg=444&text=Second slide" alt="Second slide" />
                        </div>
                        <div className="carousel-item">
                            <img className="d-block w-100" src=".../800x400?auto=yes&bg=555&fg=333&text=Third slide" alt="Third slide" />
                        </div>
                    </div>
                </div>

                {specials.map((special) => {
                    return (
                        <Special special={special} />
                    )
                })}
            </div>
        )
    }
}

export default SpecialList;