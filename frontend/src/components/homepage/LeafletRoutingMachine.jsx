import React, { useEffect } from "react";
import L from "leaflet";
import "leaflet-routing-machine";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import { useMap } from "react-leaflet";

const LeafletRoutingMachine = () => {
  const map = useMap();
  useEffect(() => {
    L.Routing.control({
        waypoints: [L.latLng(45.256872, 19.834077), L.latLng(45.258841, 19.850172)],
        routeWhileDragging: false,
        geocoder: L.Control.Geocoder.nominatim(),
    }).addTo(map);
  }, []);
  return null;
};

export default LeafletRoutingMachine;