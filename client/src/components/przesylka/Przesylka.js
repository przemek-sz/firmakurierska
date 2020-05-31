import React, { Component } from 'react';
import {Link} from 'react-router-dom';


class Przesylka extends Component{

    COURSE_API_URL = 'http://localhost:8080';
    
   /*
    wyswietlWszystkiePrzesylki = (e) => {
        e.preventDefault();
        console.log("Wszystkie Przesylki");
    }

    nadaniePrzesylki = (e) => {
        e.preventDefault();
        console.log("Nadanie Przesylki");
        this.props.history.push('/nowaPrzesylka');
    };*/

    render() {
        return (<div>
            <form>
            <Link to='/przesylkiKlienta'>  <input type="submit" value="Wyświetl moje przesylki"/></Link>
            </form>
            <form>
            <Link to='/nowaPrzesylka'> <input type="submit" value="Nadanie nowej przesylki"/></Link>
            </form>
            </div>)
    }
}
export default Przesylka;