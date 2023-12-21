package com.isamrs.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.Passenger;
import com.isamrs.backend.repositories.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id){
        return passengerRepository.findById(id);

    }

    public Passenger savePassenger(Passenger p){
        return passengerRepository.save(p);
    }
    
    public boolean deletePassengerById(Long id){
        Optional<Passenger> existing = passengerRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        passengerRepository.delete(existing.get());
        return true;
    }

    public Passenger updatePassenger(Passenger p){
        return p;
    }

    public Passenger getPassengerByEmail(String email){
        return passengerRepository.getPassengerByEmail(email);
    }
    
}
