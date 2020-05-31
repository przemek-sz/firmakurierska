import React from 'react';
import { NavLink, withRouter } from 'react-router-dom';
import '../css/Navbar.css'

class Navbar extends React.Component {

    state={
        auth: window.sessionStorage.getItem('Auth')
    }

    logout = (e) => {
        e.preventDefault();
        window.sessionStorage.setItem('AuthKey',null);
        window.sessionStorage.setItem('Auth', false);
        this.setState({auth:false});
    }

    render() {
       
        return (
            <div >
                <ul>
                    <li><NavLink exact to="/">Home</NavLink></li>
                    {(!this.state.auth) ? (
                        <div>
                            <li><NavLink to='/login'>Login</NavLink></li>
                            <li><NavLink to='/register'>Register</NavLink></li>
                        </div>
                    ) : (
                            <div>
                             <li><NavLink to='/przesylka'>Przesylki</NavLink></li>
                             <li><NavLink to='/usersList'>UsersList</NavLink></li>
                             <li onClick={this.logout}><NavLink exact to="/">Logout</NavLink></li>
                            </div>
                        )}
                </ul>
            </div>

        )
    }

}



export default withRouter(Navbar)