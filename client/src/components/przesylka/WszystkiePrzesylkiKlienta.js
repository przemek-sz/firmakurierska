import React, { Component } from 'react';
import axios from 'axios';
import '../../css/lista.css';
class WszystkiePrzesylkiKlienta extends Component{

    state = {
        przesylki: [],
        edit: false,
        przesylka: null,
        anulowalna: true
    }

    componentDidMount() {

        this.getAll();
    
    
    }

    handleClick = (p) => {
      this.setState({
        przesylka: p,
        edit:true
      })
      if(p.status==='anulowana'||p.status==='dostarczona'){
        this.setState({
          anulowalna:false
        })  
      }
  }

  anulowanieClick = (id) => {
    let authorization = window.sessionStorage.getItem('AuthKey');
    let p = this.state.przesylka;
    p.status='anulowana';
    this.setState({
      przesylka:p,
      anulowalna:false
    })    

    console.log("anulowanie")
    axios({
      'method': 'put',
      'url': 'http://localhost:8080/api/przesylka/anulowanie/' + id,
      'headers': {
        'Content-Type': 'application/json',
        authorization
      }
    })
      .then((response) => {
        this.getAll();
      })
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

      all(){
        const { przesylki } = this.state
        const przesylkiList = przesylki.length ? (
          przesylki.map(przesylka => {
            return (
              <div className="element">
                <label>Nr przesylki: </label>{przesylka.id+", "}
                <label> Adresat: </label>{przesylka.imieinazwisko+" "}
                <button onClick={() => this.handleClick(przesylka)}> Szczegoly </button>
              </div>
            )
          })
        ) : (
            <div className="element">No data</div>
          );
    
        return (
          <div>
            {przesylkiList}
          </div>
        )
      }

      one(){
        return (
          <div className="element">
               <p><label>Nr przesylki: </label>{this.state.przesylka.id}</p>
               <p><label>Adresat: </label>{this.state.przesylka.imieinazwisko}</p>
               <p><label>Tel: </label>{this.state.przesylka.tel}</p>
               <p><label>Email: </label>{this.state.przesylka.email}</p>
               <p><label>Kod pocztowy: </label>{this.state.przesylka.kodpocztowy}</p>
               <p><label>Miejscowosc: </label>{this.state.przesylka.miejscowosc}</p>
               <p><label>Ulica: </label>{this.state.przesylka.ulica}</p>
               <p><label>Nr domu: </label>{this.state.przesylka.nrdomu}</p>
               <p><label>Nr lokalu: </label>{this.state.przesylka.nrlokalu}</p>
               <p><label>Typ: </label>{this.state.przesylka.typ}</p>
               <p><label>Rozmiar: </label>{this.state.przesylka.rozmiar}</p>
               <p><label>Status: </label>{this.state.przesylka.status}</p>
               <p><label>Data: </label>{this.state.przesylka.datanadania}</p>
               <p>{this.state.anulowalna? (
              <button onClick={() => this.anulowanieClick(this.state.przesylka.id)}> Anuluj</button>
               ) : ("")}</p>
          </div>
        )
      }


      render() {
        if(this.state.edit===false)
        return(this.all())
        else return(this.one())
      }
}
export default WszystkiePrzesylkiKlienta;