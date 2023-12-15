import "./Homestyle.css";
import "leaflet/dist/leaflet.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css"

import * as React from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

import L from "leaflet";
import {MapContainer, Marker, TileLayer, useMap} from "react-leaflet"
import {Icon} from "leaflet"
import { useState, useEffect } from "react";
import { Grid, Paper } from "@mui/material";
import LeafletRoutingMachine from "./LeafletRoutingMachine";
import LeafletGeocoder from "./LeafletGeocoder";
import axios from 'axios';

export default function Home(){



    const [vehicles, setVehicles] = useState([]);
    useEffect(() => {
        const fetchVehicles = async () => {
          try {
            const response = await axios.get('http://localhost:9090/api/location/all');
            const responseData = response.data;

            setVehicles(responseData);
          } catch (error) {
            console.error('Error fetching data:', error);
          }
        };
    
        // Call the fetchVehicles function when the component mounts
        fetchVehicles();
      }, []);
    const cars = [
        {
            geocode :[45.245617, 19.838533],
            popUp: "1"
        },
        {
            geocode :[45.254375, 19.827427],
            popUp: "2"
        }
        // {
    ];

    const carIcon = new Icon({
        iconUrl: "https://static-00.iconduck.com/assets.00/taxi-icon-2048x1159-0dhn6s0u.png",
        iconSize: [36,36]
    })


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

                {vehicles.map((vehicle) => (
                    <Marker position={[vehicle.geoLongitude, vehicle.geoLatitude]} icon={carIcon}>
                    </Marker>
                ))}

                {cars.map(car => (
                    <Marker position={car.geocode} icon={carIcon}>
                    </Marker>
                ))}

                <LeafletRoutingMachine/>
            </MapContainer>

        </Grid>
    );
}