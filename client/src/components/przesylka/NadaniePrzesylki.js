import React, { Component } from 'react';
import axios from 'axios';
class NadaniePrzesylki extends Component{

    COURSE_API_URL = 'http://localhost:8080';
    state={
        imieinazwisko:'',
        tel:'',
        email:'',
        kodpocztowy:'',
        miejscowosc:'',
        ulica:'',
        nrdomu:'',
        nrlokalu:'',
        typ:'',
        rozmiar:'',
        view:'',
    }

    handleChange = (e) => {
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    handleSubmit = (e) => {
        e.preventDefault();
        this.sendData();
    }

    sendData = () => {

        let authorization = window.sessionStorage.getItem('AuthKey');
        
        axios.post('http://localhost:8080/api/przesylka',this.state, {
            headers: {'Content-Type': 'application/json',
            authorization
        }
          })
        .then((response) =>{
            this.props.history.push({
                pathname: '/nowaPrzesylka',
                przesylka: response.data
              });
        })
    }

    render(){
        return(<div>
        <form onSubmit={this.handleSubmit}>
            <label>
            Imie i nazwisko:
            <input type="text" id="imieinazwisko" onChange={this.handleChange}/>
            </label>
            <label>
            Telefon:
            <input type="text" id="tel" onChange={this.handleChange}/>
            </label>
            <label>
            Email:
            <input type="text" id="email" onChange={this.handleChange}/>
            </label>
            <label>
            Kod pocztowy:
            <input type="text" id="kodpocztowy" onChange={this.handleChange}/>
            </label>
            <label>
            Miejscowość:
            <input type="text" id="miejscowosc" onChange={this.handleChange}/>
            </label>
            <label>
            Ulica:
            <input type="text" id="ulica" onChange={this.handleChange}/>
            </label>
            <label>
            Nr domu:
            <input type="text" id="nrdomu" onChange={this.handleChange}/>
            </label>
            <label>
            Nr lokalu:
            <input type="text" id="nrlokalu" onChange={this.handleChange}/>
            </label>
            <label>
            Typ:
            <input type="text" id="typ" onChange={this.handleChange}/>
            </label>
            <label>
            Rozmiar:
            <input type="text" id="rozmiar" onChange={this.handleChange}/>
            </label>
            <input type="submit" value="Wyślij"/>
        </form>
        </div>)
    }
}
export default NadaniePrzesylki;