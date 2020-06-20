import React, { Component } from 'react';
import axios from 'axios';
import Select from 'react-select';
import '../../css/NadaniePrzesylki.css'

const options = [
  { value: 'chocolate', label: 'Chocolate' },
  { value: 'strawberry', label: 'Strawberry' },
  { value: 'vanilla', label: 'Vanilla' },
];
class NadaniePrzesylki extends Component{

    COURSE_API_URL = 'http://localhost:8080';
    state={
        przesylka:{
            id:'',
            imie:'',
            nazwisko:'',
            tel:'',
            email:'',
            kodpocztowy:'',
            miejscowosc:'',
            ulica:'',
            nrdomu:'',
            nrlokalu:'',
            typ:'',
            rozmiar:'',
            waga:'',
            pobranie:'',
            status:''
            },
        typy:[],
        rozmiary:[],
        view:'',
        edit:false,
        failed:false,
        selectedOption:''
    }

    componentDidMount(){
        console.log(this.props.location.przesylka);
        this.getRozmiar();
        if(!(this.props.location.przesylka===undefined)){
            console.log(this.props.location.przesylka);
            this.setState({
                edit: true,
                przesylka:this.props.location.przesylka
            })
        }
             this.getTypes();
             this.setState({
                view: 'typ'
            })
        
       
    }

    handleChange = (e) => {
        let p = this.state.przesylka;
        
        p[e.target.id] = e.target.value;
        
        this.setState({
            przesylka: p
        })
    }

    handleSubmit = (e) => {
        e.preventDefault();
        console.log(this.state.przesylka);
        this.sendData();
    }

    handleClick = (t) => {
        if(window.sessionStorage.getItem('AuthKey')==='null')
        {
            this.props.history.push("login");
        }
        let p = this.state.przesylka;
        p.typ=t.id;
        if(this.state.edit){
            this.setState({
                przesylka: p,
                view: 'editForm'
              })
        }
        else{
        this.setState({
          przesylka: p,
          view: 'form'
        })
        }
    }

    handleOption= selectedOption => {
      let p = this.state.przesylka;
      p.rozmiar=selectedOption.value;
      this.setState({ 
       przesylka:p,
       selectedOption:selectedOption
      });
    };

    getTypes = () => {

        axios({
            'method': 'get',
            'url': 'http://localhost:8080/api/typ',
            'headers': {
              'Content-Type': 'application/json'
            }
          })
            .then((response) => {
              this.setState({
                typy: response.data
              })
            });

    }

    getRozmiar = () => {

      axios({
          'method': 'get',
          'url': 'http://localhost:8080/api/rozmiar',
          'headers': {
            'Content-Type': 'application/json'
          }
        })
          .then((response) => {
            this.setState({
              rozmiary: response.data
            })
          });

  }

    sendData = () => {

        let authorization = window.sessionStorage.getItem('AuthKey');
        
        if(this.state.edit===false){
            axios.post('http://localhost:8080/api/przesylka',this.state.przesylka, {
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
        .catch((error) =>{
          this.setState({
            failed:true
          })
        })
        }else{
            axios.put('http://localhost:8080/api/przesylka',this.state.przesylka, {
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
        .catch((error) =>{
          this.setState({
            failed:true
          })
        })
        }

    }


    typForm(){
        const { typy } = this.state
        const typList = typy.length ? (
          typy.map(typ => {
            return (
              <div className="element">
            <button onClick={() => this.handleClick(typ)}> {typ.nazwa+" "+typ.koszt+" zł"} </button>
              </div>
            )
          })
        ) : (
            <div className="element">No data</div>
          );
    
        return (
          <div>
            {typList}
          </div>
        )
    }
    

    form(){
        console.log("Form");
        const { selectedOption } = this.state;
        return(<div>
            <form onSubmit={this.handleSubmit}>
                {(this.state.failed===true) ?
                  (<label className="errorlabel">Niepoprawne dane!</label>):
                  (<label></label>)
                }
                <p></p>
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
                Rozmiar:
                <Select
                   name="form-field-name"
                   value={selectedOption}
                   onChange={this.handleOption}
                   options={this.state.rozmiary}
                />
                </label>
                <p></p>
                <label>
                Waga:
                <input type="text" id="waga" onChange={this.handleChange}/>
                </label>
                {!(this.state.przesylka.typ===1) ?
                  (<label></label>):
                  (<label>Pobranie:
                    <input type="text" id="pobranie" onChange={this.handleChange}/></label>)
                }
                <input className="buttonSend" type="submit" value="Wyślij"/>
            </form>
            </div>)
    }

    editForm(){
        console.log("EditForm");
        const { selectedOption } = this.state;
        return(<div>
            <form onSubmit={this.handleSubmit}>
                {(this.state.failed===true) ?
                  (<label className="errorlabel">Niepoprawne dane!</label>):
                  (<label></label>)
                }
                <p></p>
                <label>
                Imie:
                <input type="text" id="imie" defaultValue={this.state.przesylka.imie} onChange={this.handleChange}/>
                </label>
                <label>
                Nazwisko:
                <input type="text" id="nazwisko" defaultValue={this.state.przesylka.nazwisko} onChange={this.handleChange}/>
                </label>
                <label>
                Telefon:
                <input type="text" id="tel" defaultValue={this.state.przesylka.tel} onChange={this.handleChange}/>
                </label>
                <label>
                Email:
                <input type="text" id="email" defaultValue={this.state.przesylka.email} onChange={this.handleChange}/>
                </label>
                <label>
                Kod pocztowy:
                <input type="text" id="kodpocztowy" defaultValue={this.state.przesylka.kodpocztowy} onChange={this.handleChange}/>
                </label>
                <label>
                Miejscowość:
                <input type="text" id="miejscowosc" defaultValue={this.state.przesylka.miejscowosc} onChange={this.handleChange}/>
                </label>
                <label>
                Ulica:
                <input type="text" id="ulica" defaultValue={this.state.przesylka.ulica} onChange={this.handleChange}/>
                </label>
                <label>
                Nr domu:
                <input type="text" id="nrdomu" defaultValue={this.state.przesylka.nrdomu} onChange={this.handleChange}/>
                </label>
                <label>
                Nr lokalu:
                <input type="text" id="nrlokalu" defaultValue={this.state.przesylka.nrlokalu} onChange={this.handleChange}/>
                </label>
                <label>
                Rozmiar:
                <Select
                   name="form-field-name"
                   value={selectedOption}
                   onChange={this.handleOption}
                   options={this.state.rozmiary}
                />
                </label>
                <p></p>
                <label>
                Waga:
                <input type="text" id="waga" defaultValue={this.state.przesylka.waga} onChange={this.handleChange}/>
                </label>
                {(this.state.przesylka.typ===1) ?
                  (<label>Pobranie:
                    <input type="text" id="pobranie" defaultValue={this.state.przesylka.pobranie} onChange={this.handleChange}/></label>):
                  (<label></label>)
                }
                <input className="buttonSend" type="submit" value="Wyślij"/>
            </form>
            </div>)
    }

    render(){
       if(this.state.view==='typ'){
           return this.typForm();
       }
       
       if(this.state.view==='editForm'){
        console.log("else");
           return this.editForm();
       }
       else{
           return this.form();
       }
    
    }
}
export default NadaniePrzesylki;