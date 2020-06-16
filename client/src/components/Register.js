import React, { Component } from 'react';
import axios from 'axios';

//axios.defaults.baseURL='http://localhost:8080';
 

class Register extends Component {
    COURSE_API_URL = 'http://localhost:8080';
    state={
        username:'',
        email:'',
        password:'',
        imie:'',
        nazwisko:'',
        telefon:'',
        kodpocztowy:'',
        miasto:'',
        ulica:'',
        numerdomu:'',
        nrlokalu:'',
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
        
        axios.post('http://localhost:8080/api/user',this.state)
        .then((response) =>{
            this.props.history.push("/");
        })
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                    Username:
                    <input type="text" id="username" onChange={this.handleChange}/>
                    </label>
                    <label>
                    Password:
                    <input type="text" id="password" onChange={this.handleChange}/>
                    </label>
                    <label>
                    Email:
                    <input type="text" id="email" onChange={this.handleChange}/>
                    </label>
                    <label>
                    Imie:
                    <input type="text" id="imie" onChange={this.handleChange}/>
                    </label>
                    <label>
                    Nazwisko:
                    <input type="text" id="nazwisko" onChange={this.handleChange}/>
                    </label>
                    <label>
                    Telefon:
                    <input type="text" id="telefon" onChange={this.handleChange}/>
                    </label>
                    <label>
                    Kod pocztowy:
                    <input type="text" id="kodpocztowy" onChange={this.handleChange}/>
                    </label><label>
                    Miasto:
                    <input type="text" id="miasto" onChange={this.handleChange}/>
                    </label><label>
                    Ulica:
                    <input type="text" id="ulica" onChange={this.handleChange}/>
                    </label><label>
                    Nr domu:
                    <input type="text" id="numerdomu" onChange={this.handleChange}/>
                    </label><label>
                    Nr lokalu:
                    <input type="text" id="nrlokalu" onChange={this.handleChange}/>
                    </label>
                    <input type="submit" value="Wyślij"/>
                </form>

            </div>
        )
    }
}

export default Register;
