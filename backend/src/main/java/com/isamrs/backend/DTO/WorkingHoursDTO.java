package com.isamrs.backend.DTO;

import java.time.LocalTime;
import java.util.List;

import com.isamrs.backend.models.Driver;
import com.isamrs.backend.models.WorkingHours;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHoursDTO {

    private Long id;
    private LocalTime start;
    private LocalTime end;
    private List<Driver> drivers;

    public WorkingHoursDTO(WorkingHours wkh){
        this.id = wkh.getId();
        this.start = wkh.getStart();
        this.end = wkh.getEnd();
        this.drivers = wkh.getDrivers();
    }
    
}
