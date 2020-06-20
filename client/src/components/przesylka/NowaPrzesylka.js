import React, { Component } from 'react';
import axios from 'axios';
import { matchPath } from 'react-router'
import '../../css/lista.css';
class NowaPrzesylka extends Component{

    state={
        przesylka:''
    }

    componentDidMount() {

        console.log(this.props.location.przesylka);

        this.setState({
            przesylka: this.props.location.przesylka
        })
    
    
    }

    render(){
        return (
            <div className="element">
                 <p><label>Nr przesylki: </label>{this.state.przesylka.id}</p>
                 <p><label>Adresat: </label>{this.state.przesylka.imie+" "+this.state.przesylka.nazwisko}</p>
                 <p><label>Tel: </label>{this.state.przesylka.tel}</p>
                 <p><label>Email: </label>{this.state.przesylka.email}</p>
                 <p><label>Kod pocztowy: </label>{this.state.przesylka.kodpocztowy}</p>
                 <p><label>Miejscowosc: </label>{this.state.przesylka.miejscowosc}</p>
                 <p><label>Ulica: </label>{this.state.przesylka.ulica}</p>
                 <p><label>Nr domu: </label>{this.state.przesylka.nrdomu}</p>
                 <p><label>Nr lokalu: </label>{this.state.przesylka.nrlokalu}</p>
                 <p><label>Typ: </label>{this.state.przesylka.typ}</p>
                 <p><label>Rozmiar: </label>{this.state.przesylka.rozmiar}</p>
                 <p><label>Waga: </label>{this.state.przesylka.waga}</p>
                 <p><label>Status: </label>{this.state.przesylka.status}</p>
                 <p><label>Koszt: </label>{this.state.przesylka.koszt}</p>
                 <p><label>Pobranie: </label>{this.state.przesylka.pobranie}</p>
                 <p><label>Data: </label>{this.state.przesylka.datanadania}</p>
            </div>
          )
    }

}
export default NowaPrzesylka;