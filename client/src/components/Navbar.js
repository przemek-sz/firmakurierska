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
        this.setState({auth:window.sessionStorage.getItem('Auth')});
    }

    render() {

        // if(this.state.auth==='true'){
        //     console.log("prawda "+this.state.auth);
        // }
        // if(this.state.auth===null||this.state.auth==='false'){
        //     console.log("falsz");
        // }
       
        // //console.log(this.state.auth);
        // let out;
        // if(this.state.auth==='true'){
        //     //console.log(this.state.auth);
        //     out=<div>
        //             <li><NavLink to='/usersList'>UsersList</NavLink></li>
        //             <li onClick={this.logout}><NavLink exact to="/">Logout</NavLink></li>
        //         </div>
        // }
        // else {
        //     //console.log(this.state.auth);
        //     out=<div>
        //             <li><NavLink to='/login'>Login</NavLink></li>
        //             <li><NavLink to='/register'>Register</NavLink></li>
        //         </div>
        // }
        return (

            
            <div >
                <ul>
                    <li><NavLink exact to="/">Home</NavLink></li>
                    <li><NavLink to='/przesylka'>Przesylki</NavLink></li>
                    
                    {(this.state.auth==='true') ? (
                        <div>
                             <li><NavLink to='/usersList'>UsersList</NavLink></li>
                             <li onClick={this.logout}><NavLink exact to="/">Logout</NavLink></li>
                        </div>
                    ) : (
                        <div>
                            <li><NavLink to='/login'>Login</NavLink></li>
                            <li><NavLink to='/register'>Register</NavLink></li>
                        </div> 
                        )}
                </ul>
            </div>

        )
    }

}



export default withRouter(Navbar)