import "./Homestyle.css";
import "leaflet/dist/leaflet.css";

import {MapContainer, Marker, TileLayer} from "react-leaflet"
import {Icon} from "leaflet"

export default function Home(){


    //TODO: load vozila iz baze i prikaz njih (i korisnika)
    // marker za trenutnu lokaciju + lista markera lokacija vozila(druga ikonica, sa popupom vehicleId-a)
    const vehicles = [
        {
            geocode :[45.245617, 19.838533],
            popUp: "1"
        },
        {
            geocode :[45.256872, 19.834077],
            popUp: "2"
        },
        {
            geocode :[45.258841, 19.850172],
            popUp: "3"
        }
    ];

    const carIcon = new Icon({
        iconUrl: "https://static-00.iconduck.com/assets.00/taxi-icon-2048x1159-0dhn6s0u.png",
        iconSize: [36,36]
    })

    const myLocation = [
        {
            geocode :[45.251605, 19.851990],
            popUp: "1"
        }
    ]
    return(

        <MapContainer center={[45.267136,19.833549]} zoom={13}>
            <TileLayer
                attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />

            {vehicles.map(vehicle => (
                <Marker position={vehicle.geocode} icon={carIcon}>
                </Marker>
            ))}

            {myLocation.map(myloc => (
                <Marker position={myloc.geocode}>
                </Marker>
            ))}
        </MapContainer>
    );
}