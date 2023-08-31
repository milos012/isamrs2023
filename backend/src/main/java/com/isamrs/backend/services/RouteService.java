package com.isamrs.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.Route;
import com.isamrs.backend.repositories.RouteRepository;


@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<Route> getRouteById(Long id){
        return routeRepository.findById(id);

    }

    public Route saveRoute(Route route){
        return routeRepository.save(route);
    }

    public boolean deleteRouteById(Long id){
        Optional<Route> existing = routeRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        routeRepository.delete(existing.get());
        return true;
    }

    public Route updateRoute(Route route){
        //TODO
        return route;
    }

    
}
