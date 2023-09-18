import "./Homestyle.css";
import "leaflet/dist/leaflet.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css"

import * as React from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

import L from "leaflet";
import {MapContainer, Marker, TileLayer, useMap} from "react-leaflet"
import {Icon} from "leaflet"
import { useState } from "react";
import { Grid, Paper } from "@mui/material";
import LeafletRoutingMachine from "./LeafletRoutingMachine";
import LeafletGeocoder from "./LeafletGeocoder";

export default function Home(){


    // const [pocetak, setPocetak] = React.useState('');
    // const [kraj, setKraj] = React.useState('');

    //TODO: load vozila iz baze i prikaz njih (i korisnika)
    // marker za trenutnu lokaciju + lista markera lokacija vozila(druga ikonica, sa popupom vehicleId-a)
    const vehicles = [
        {
            geocode :[45.245617, 19.838533],
            popUp: "1"
        }
        // {
        //     geocode :[45.256872, 19.834077],
        //     popUp: "2"
        // },
        // {
        //     geocode :[45.258841, 19.850172],
        //     popUp: "3"
        // }
    ];

    const carIcon = new Icon({
        iconUrl: "https://static-00.iconduck.com/assets.00/taxi-icon-2048x1159-0dhn6s0u.png",
        iconSize: [36,36]
    })

    // const changeHandler = (e) => {
    //     this.setState({[e.currentTarget.name]: e.currentTarget.value})
    // }

    // submitHandler = (e) => {
    //     e.preventDefault()

    //     console.log(this.state)
    // }

    // const handleSubmit = async (event) => {
    //     event.preventDefault();
    //     const data = new FormData(event.currentTarget);
    //     console.log({
    //       pocetak: data.get('pocetak'),
    //       kraj: data.get('kraj'),
    //     });
    // }

    //const [myLocation,setMyLocation] = useState({lng:45.251605, lat: 19.851990});
    return(
        
        <Grid>

            {/* <form >
            <TextField
                        name="pocetak"
                        variant="outlined"
                        required
                        id="pocetak"
                        label="Polaziste"
                        autoFocus
                        value={pocetak}
                        // onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        required
                        id="kraj"
                        label="Odrediste"
                        name="kraj"
                        value={kraj}
                        // onChange={this.changeHandler}
                    />
                    <Button
                    type="submit"
                    variant="contained"
                    color="primary"
                    >
                        Submit
                    </Button>
            </form> */}
            <MapContainer center={[45.267136,19.833549]} zoom={13}>
                <TileLayer
                    attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                />

                {vehicles.map(vehicle => (
                    <Marker position={vehicle.geocode} icon={carIcon}>
                    </Marker>
                ))}

                {/* <Marker position={[myLocation.lng, myLocation.lat]} draggable={true} onDragma>
                </Marker> */}
                {/* {myLocation.map(myloc => (
                    <Marker position={myloc.geocode} draggable={true}>
                    </Marker>
                ))} */}
                <LeafletRoutingMachine/>
                {/* <LeafletGeocoder/> */}
            </MapContainer>

        </Grid>
    );
}