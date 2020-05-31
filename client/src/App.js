import React from 'react';
import { Route, BrowserRouter, Switch } from 'react-router-dom'
import Home from './components/Home'
import Register from './components/Register'
import Login from './components/Login'
import UsersList from './components/UsersList'
import Navbar from './components/Navbar'
import Przesylka from './components/przesylka/Przesylka';
import WszystkiePrzesylkiKlienta from './components/przesylka/WszystkiePrzesylkiKlienta';
import NowaPrzesylka from './components/przesylka/NowaPrzesylka';


function App() {
  window.sessionStorage.setItem('Auth',false);
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
        <Route path="/nowaPrzesylka" component={NowaPrzesylka}/>
        <Route path="/przesylkiKlienta" component={WszystkiePrzesylkiKlienta}/>
      </Switch>
     
      
    {/* <Navbar bg="primary" variant="dark">
    <Switch>
    <Navbar.Brand href="#home">Navbar</Navbar.Brand>
    <Nav className="mr-auto">
      <Nav.Link href="#home">Home</Nav.Link>
      <Nav.Link href="#features">Features</Nav.Link>
      <Nav.Link href="#pricing">Pricing</Nav.Link>
    </Nav>
    <Form inline>
      <FormControl type="text" placeholder="Search" className="mr-sm-2" />
      <Button variant="outline-light">Search</Button>
    </Form>
    </Switch>
  </Navbar> */}
      
    </div>
    </BrowserRouter>
  );
}

export default App;
