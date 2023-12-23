package com.saiabreu.aptmaintenance.domain.maintenceRequest.services;

import com.saiabreu.aptmaintenance.domain.core.exceptions.ResourceCreationException;
import com.saiabreu.aptmaintenance.domain.core.exceptions.ResourceNotFoundException;
import com.saiabreu.aptmaintenance.domain.maintenceRequest.models.MaintenceRequest;
import com.sun.tools.javac.Main;

import java.util.List;

public interface MaintenceRequestService {
    MaintenceRequest create(MaintenceRequest maintenceRequest) throws ResourceCreationException;
    MaintenceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenceRequest getByEmail(String email) throws ResourceNotFoundException;
    MaintenceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException;
    MaintenceRequest getByDescription(String description) throws ResourceNotFoundException;
    List<MaintenceRequest> getAll();
    MaintenceRequest update(Long id, MaintenceRequest maintenanceRequestDetail) throws ResourceNotFoundException;
    void delete(Long id);


}
