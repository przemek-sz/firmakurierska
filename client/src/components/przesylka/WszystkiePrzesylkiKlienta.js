import React, { Component } from 'react';
import axios from 'axios';
class WszystkiePrzesylkiKlienta extends Component{

    state = {
        przesylki: []
    }

    componentDidMount() {

        this.getAll();
    
      }

    getAll() {
        let authorization = window.sessionStorage.getItem('AuthKey');
    
        axios({
          'method': 'get',
          'url': 'http://localhost:8080/api/przesylka',
          'headers': {
            'Content-Type': 'application/json',
            authorization
          }
        })
          .then((response) => {
            this.setState({
              przesylki: response.data
            })
          });
    
      }

      render() {
        const { przesylki } = this.state
        const przesylkiList = przesylki.length ? (
          przesylki.map(przesylka => {
            return (
              <div>
                <label>Id: </label>{przesylka.id}
                <label>Imie i nazwisko: </label>{przesylka.imieinazwisko}
              </div>
            )
          })
        ) : (
            <div className="center">No data</div>
          );
    
        return (
          <div>
            {przesylkiList}
          </div>
        )
      }
}
export default WszystkiePrzesylkiKlienta;