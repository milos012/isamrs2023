import React, {Component} from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import { makeStyles } from '@mui/material/styles';
import Alert from '@mui/material/Alert';
import { Paper } from '@mui/material';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Checkbox from '@mui/material/Checkbox';
import FormGroup from '@mui/material/FormGroup';
import axios from 'axios';

const paperStyle={padding: "30px 50px",width:370,margin:"20px auto"}
const avatarStyle={backgroundColor: "#1bbd7e"}
const headerStyle={margin:0}
const marginTop={marginTop:5}


function AlertSucc() {
  const [open, setOpen] = React.useState(true);
  return (
    //Popup.alert('You pressed the Save btn')
    <Alert
    >
      Close me!
    </Alert>
  );
}

const headerConfig = {
    headers:{
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json'
    }
}

class RegisterDriver extends React.Component {
    constructor(props){
        super(props)

        this.state = {
            name: '',
            price: '',
            category: '',
            description: '',
            availability: false,
            image:''

        }
    }

    changeHandler = (e) => {
        this.setState({[e.currentTarget.name]: e.currentTarget.value})
    }

    changeActivityHandler = (e) => {
        const value = e.currentTarget.value === 'true';
        this.setState({
            active: value
        });
    };

    changeBabyHandler = (e) => {
        const value = e.currentTarget.value === 'true';
        this.setState({
            babyFriendly: value
        });
    };

    changePetHandler = (e) => {
        const value = e.currentTarget.value === 'true';
        this.setState({
            petFriendly: value
        });
    };

      

    submitHandler = (e) => {
        e.preventDefault()
        //Setting blocked to false
        this.setState({
            blocked: 'false'
        });

        console.log(this.state)

        axios.post('http://localhost:9090/api/driver/post',this.state,
        {
            headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin': '*'},
            withCredentials: true
        }).then(response=>
        {
            console.log(response)
        })
        .catch(error =>{
            console.log(error)
        })
    }

    render() { 
        const {fName, lName, city, phoneNumber, email, password, blocked ,active, imgUrl, vozacka, saobracajna, model, registrationNumber, slotNumber, babyFriendly, petFriendly} = this.state
        return (
            <Grid>
            <Paper elevation={20} style={paperStyle}>
                <Grid>
                    <h2 style={headerStyle}>Register new Driver</h2>
                </Grid>
                <form onSubmit={this.submitHandler}>
                    <TextField
                        name="fName"
                        variant="outlined"
                        required
                        fullWidth
                        id="fName"
                        label="First name"
                        autoFocus
                        style={marginTop}
                        value={fName}
                        onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        id="lName"
                        label="Last Name"
                        name="lName"
                        style={marginTop}
                        value={lName}
                        onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        fullWidth
                        required
                        id="city"
                        label="City"
                        name="city"
                        style={marginTop}
                        value={city}
                        onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        fullWidth
                        required
                        id="phoneNumber"
                        label="Phone Number"
                        name="phoneNumber"
                        style={marginTop}
                        value={phoneNumber}
                        onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        fullWidth
                        required
                        id="email"
                        label="Email"
                        name="email"
                        style={marginTop}
                        value={email}
                        onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        fullWidth
                        required
                        id="password"
                        label="Password"
                        name="password"
                        type="password"
                        style={marginTop}
                        value={password}
                        onChange={this.changeHandler}
                    />

                    <FormControl component="fieldset" style={marginTop}>
                        <FormLabel component="legend">Active*</FormLabel>
                        <RadioGroup aria-label="Active" name="active" style={{display:'initial'}} value={active} onChange={this.changeActivityHandler}>
                            <FormControlLabel value="true" control={<Radio />} label="Active" />
                            <FormControlLabel value="false" control={<Radio />} label="Not active" />
                        </RadioGroup>
                    </FormControl>
                    <label>Profile Image</label>
                    <TextField
                        variant="outlined"
                        fullWidth
                        id="imgUrl"
                        name="imgUrl"
                        type="file"
                        style={marginTop}
                        value={imgUrl}
                        onChange={this.changeHandler}
                    />
                    <label>Vozacka dozvola</label>
                    <TextField
                        variant="outlined"
                        fullWidth
                        id="vozacka"
                        name="vozacka"
                        type="file"
                        style={marginTop}
                        value={vozacka}
                        onChange={this.changeHandler}
                    />
                    <label>Saobracajna dozvola</label>
                    <TextField
                        variant="outlined"
                        fullWidth
                        id="saobracajna"
                        name="saobracajna"
                        type="file"
                        style={marginTop}
                        value={saobracajna}
                        onChange={this.changeHandler}
                    />
                    <h2 style={headerStyle}>Driver's vehicle</h2>
                    <TextField
                        variant="outlined"
                        fullWidth
                        required
                        id="model"
                        label="Vehicle model"
                        name="model"
                        style={marginTop}
                        value={model}
                        onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        fullWidth
                        required
                        id="registrationNumber"
                        label="Registration Number"
                        name="registrationNumber"
                        style={marginTop}
                        value={registrationNumber}
                        onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        fullWidth
                        required
                        id="slotNumber"
                        label="Number of seats"
                        name="slotNumber"
                        type='number'
                        style={marginTop}
                        value={slotNumber}
                        onChange={this.changeHandler}
                    />
                    <FormControl component="fieldset" style={marginTop}>
                        <FormLabel component="legend">Baby Friendly*</FormLabel>
                        <RadioGroup aria-label="babyFriendly" name="babyFriendly" style={{display:'initial'}} value={babyFriendly} onChange={this.changeBabyHandler}>
                            <FormControlLabel value="true" control={<Radio />} label="Yes" />
                            <FormControlLabel value="false" control={<Radio />} label="No" />
                        </RadioGroup>
                    </FormControl>
                    <FormControl component="fieldset" style={marginTop}>
                        <FormLabel component="legend">Pet friendly*</FormLabel>
                        <RadioGroup aria-label="Pet Friendly" name="petFriendly" style={{display:'initial'}} value={petFriendly} onChange={this.changePetHandler}>
                            <FormControlLabel value="true" control={<Radio />} label="Yes" />
                            <FormControlLabel value="false" control={<Radio />} label="No" />
                        </RadioGroup>
                    </FormControl>
                    <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    color="primary"
                    >
                        Submit
                    </Button>
                </form>
            </Paper>
        </Grid>
          );
    }
}
 
export default RegisterDriver;