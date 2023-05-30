import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { Alert } from '@mui/material';
import { useNavigate } from 'react-router-dom';


import { useRef, useState, useEffect } from "react";
import { faCheck, faTimes, faInfoCircle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import axios from 'axios';

const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;


const theme = createTheme();


export default function SignUp() {

  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);


    let fName = data.get('firstName');
    let lName = data.get('lastName');
    let city = data.get('city');
    let phoneNumber = data.get('phoneNumber');
    let email = data.get('email');
    // Checking password
    //TODO: Display error if it doenst match, axios call if it matches
    let password = data.get('password');
    let passwordConf = data.get('passwordConf');
    let blocked = false;


    if (password.length != 0){
      if (password == passwordConf){
        console.log("password matches")
        try {
          // data will be an error? send all the let-s created above instead
          axios.post("http://localhost:9000/api/register",data,
            {
                headers: { 'Content-Type': 'application/json' ,'Access-Control-Allow-Origin': '*'},
                withCredentials: true
            });
        } catch (error) {
          console.log(error)
        }
    
        navigate('/')
  
      }
      else{
        console.log("password doesn't match")
        alert("Password doesn't match!")
      }
    }

  };

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Sign up
          </Typography>
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="given-name"
                  name="firstName"
                  required
                  fullWidth
                  id="firstName"
                  label="First Name"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  id="lastName"
                  label="Last Name"
                  name="lastName"
                  autoComplete="family-name"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="city"
                  name="city"
                  required
                  fullWidth
                  id="city"
                  label="City"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  id="phoneNumber"
                  label="Phone number"
                  name="phoneNumber"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  autoComplete="new-password"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="passwordConf"
                  label="Confirm Password"
                  type="password"
                  id="passwordConf"
                />
              </Grid>
              
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Sign Up
            </Button>
            <Grid container justifyContent="flex-end">
              <Grid item>
                <Link href="/signIn" variant="body2">
                  Already have an account? Sign in
                </Link>
              </Grid>
            </Grid> 
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}