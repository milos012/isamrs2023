package com.isamrs.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isamrs.backend.DTO.RouteDTO;
import com.isamrs.backend.models.Route;
import com.isamrs.backend.services.RouteService;


@RestController
@RequestMapping(value = "/api/route", produces = MediaType.APPLICATION_JSON_VALUE)
public class RouteController {

    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<RouteDTO>> getAllRoutes(){

        List<Route> routes = routeService.getAllRoutes();

        //Convert to DTO's
        List<RouteDTO> locDTOs = new ArrayList<RouteDTO>();
        for (Route rt : routes) {
            locDTOs.add(new RouteDTO(rt));
        }

        return new ResponseEntity<>(locDTOs, HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<RouteDTO> getRouteById(@PathVariable Long id){
		
		Optional<Route> rt = routeService.getRouteById(id);
		
		if (rt != null) {
			return new ResponseEntity<>(new RouteDTO(rt.get()), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<RouteDTO> saveRoute(@RequestBody RouteDTO routeDTO) throws Exception {

        Route route = new Route();

        route.setId(routeDTO.getId());
        route.setPocetak(routeDTO.getPocetak());
        route.setKraj(routeDTO.getKraj());
        route.setKilometraza(routeDTO.getKilometraza());
        route.setProcenjenoVreme(routeDTO.getProcenjenoVreme());
        route.setCena(routeDTO.getCena());

        routeService.saveRoute(route);

		return new ResponseEntity<>(new RouteDTO(route), HttpStatus.CREATED);
	}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ResponseEntity<RouteDTO> deleteRouteById(@PathVariable Long id){
		
		Optional<Route> rt = routeService.getRouteById(id);
		
		if (rt != null) {
            routeService.deleteRouteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
}
