import React from 'react';
import { Route, BrowserRouter, Switch } from 'react-router-dom'
import Home from './components/Home'
import Register from './components/Register'
import Login from './components/Login'
import UsersList from './components/UsersList'
import Navbar from './components/Navbar'
import Przesylka from './components/przesylka/Przesylka';
import WszystkiePrzesylkiKlienta from './components/przesylka/WszystkiePrzesylkiKlienta';
import NadaniePrzesylki from './components/przesylka/NadaniePrzesylki';
import NowaPrzesylka from './components/przesylka/NowaPrzesylka';


function App() {
  //window.sessionStorage.setItem('Auth',Boolean(false));
  return (
    <BrowserRouter>
    <div className="App">
      
      <Navbar />
      <Switch>
        <Route exact path="/" component={Home}/>
        <Route path="/register" component={Register}/>
        <Route path="/login" component={Login}/>
        <Route path="/usersList" component={UsersList}/>
        <Route path="/przesylka" component={Przesylka}/>
        <Route path="/nadaniePrzesylki" component={NadaniePrzesylki}/>
        <Route path="/nowaPrzesylka" component={NowaPrzesylka}/>
        <Route path="/przesylkiKlienta" component={WszystkiePrzesylkiKlienta}/>
      </Switch>
      
    </div>
    </BrowserRouter>
  );
}

export default App;
