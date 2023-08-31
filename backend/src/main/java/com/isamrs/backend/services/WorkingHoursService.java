package com.isamrs.backend.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.WorkingHours;
import com.isamrs.backend.repositories.WorkingHoursRepository;


@Service
public class WorkingHoursService {

    @Autowired
    WorkingHoursRepository workingHoursRepository;

    public List<WorkingHours> getAllWorkingHours() {
        return workingHoursRepository.findAll();
    }

    public Optional<WorkingHours> getWorkingHoursById(Long id){
        return workingHoursRepository.findById(id);

    }

    public WorkingHours saveWorkingHours(WorkingHours wkh){
        return workingHoursRepository.save(wkh);
    }
    
    public boolean deleteWorkingHoursById(Long id){
        Optional<WorkingHours> existing = workingHoursRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        workingHoursRepository.delete(existing.get());
        return true;
    }

    public WorkingHours updateWorkingHours(WorkingHours wkh){
        //TODO
        return wkh;
    }
}
