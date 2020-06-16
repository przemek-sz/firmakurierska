import React, { Component } from 'react';
import {Link} from 'react-router-dom';


class Przesylka extends Component{

    COURSE_API_URL = 'http://localhost:8080';

    state={
        auth: window.sessionStorage.getItem('Auth')
    }
    
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
        // return (<div>
        //     <form>
        //     <Link to='/przesylkiKlienta'>  <input type="submit" value="Wyświetl moje przesylki"/></Link>
        //     </form>
        //     <form>
        //     <Link to='/nadaniePrzesylki'> <input type="submit" value="Nadanie nowej przesylki"/></Link>
        //     </form>
        //     </div>)
        console.log(window.sessionStorage.getItem('Auth'));
        return (
            
            <div>
                <form>
                <Link to='/nadaniePrzesylki'> <input type="submit" value="Nadanie nowej przesylki"/></Link>
                </form>

                {(this.state.auth==='true') ? (
                    <div>
                        <form>
                        <Link to='/przesylkiKlienta'>  <input type="submit" value="Wyświetl moje przesylki"/></Link>
                        </form>  
                    </div>
                    ) : (
                    <div>
                     
                    </div>
                    )}
                
            </div>

        )

    }
}
export default Przesylka;