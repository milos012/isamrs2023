package com.isamrs.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamrs.backend.models.Drive;
import com.isamrs.backend.repositories.DriveRepository;


@Service
public class DriveService {

    @Autowired
    DriveRepository driveRepository;

    public List<Drive> getAllDrives() {
        return driveRepository.findAll();
    }

    public Optional<Drive> getDriveById(Long id){
        return driveRepository.findById(id);

    }

    public Drive saveDrive(Drive dr){
        return driveRepository.save(dr);
    }

    public boolean deleteDriveById(Long id){
        Optional<Drive> existing = driveRepository.findById(id);
        if(existing.isEmpty()){
            return false;
        }
        driveRepository.delete(existing.get());
        return true;
    }

    public Drive updateDrive(Drive dr){
        //TODO
        return dr;
    }
    
}
