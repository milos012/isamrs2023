import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


const defaultTheme = createTheme();

export default function EditUser() {

    //TODO dodaj stvari koje se menjaju - fname, lname, email, password, phoneNumber, imgUrl, address
    const [fname, setFname] = React.useState('');
    const [lname, setLname] = React.useState('');
    const [email, setEmail] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [phoneNumber, setPhoneNumber] = React.useState('');
    const [imgUrl, setImgUrl] = React.useState('');
    const [address, setAddress] = React.useState('');
    const navigate = useNavigate();


  const handleSubmit = async (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    console.log({
        fname: data.get('fname'),
        lname: data.get('lname'),
        password: data.get('password'),
        phoneNumber: data.get('phoneNumber'),
        imgUrl: data.get('imgUrl'),
        address: data.get('address')
    });

    try {
        //TODO izmeni putanju - i ceo try
        const response = axios.put("http://localhost:9090/passenger/edit/${user.id}",
          data,
          {
              headers: { 'Content-Type': 'application/json' ,'Access-Control-Allow-Origin': '*'},
              withCredentials: true
          });
        const accessToken = (await response)?.data?.accessToken;
        const roles = (await response)?.data?.roles;
        setAuth({ email, password, roles, accessToken });
        setEmail('');
        setPassword('');
      } catch (error) {
        console.log("Error! User update failed!")
      }
  
      navigate('/')

  };

  return (
    <ThemeProvider theme={defaultTheme}>
      <Grid container component="main" sx={{ height: '100vh' }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage: 'url(https://source.unsplash.com/random?wallpapers)',
            backgroundRepeat: 'no-repeat',
            backgroundColor: (t) =>
              t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900],
            backgroundSize: 'cover',
            backgroundPosition: 'center',
          }}
        />
        <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
          <Box
            sx={{
              my: 8,
              mx: 4,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
          >
            <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 1 }}>
            <TextField
                margin="normal"
                required
                fullWidth
                id="fname"
                label="First name"
                name="fname"
                autoComplete="fname"
                autoFocus
              />
              <TextField
                margin="normal"
                required
                fullWidth
                id="lname"
                label="Last name"
                name="lname"
                autoComplete="lname"
                autoFocus
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="phoneNumber"
                label="Phone Number"
                id="phoneNumber"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="address"
                label="Address"
                id="address"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Edit
              </Button>
            </Box>
          </Box>
        </Grid>
      </Grid>
    </ThemeProvider>
  );
}