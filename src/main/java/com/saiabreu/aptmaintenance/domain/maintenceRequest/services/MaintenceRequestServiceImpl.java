package com.saiabreu.aptmaintenance.domain.maintenceRequest.services;

import com.saiabreu.aptmaintenance.domain.core.exceptions.ResourceCreationException;
import com.saiabreu.aptmaintenance.domain.core.exceptions.ResourceNotFoundException;
import com.saiabreu.aptmaintenance.domain.maintenceRequest.models.MaintenceRequest;
import com.saiabreu.aptmaintenance.domain.maintenceRequest.repos.MaintenceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenceRequestServiceImpl implements MaintenceRequestService {
     private MaintenceRequestRepo maintenceRequestRepo;

        @Autowired
        public MaintenceRequestServiceImpl(MaintenceRequestRepo maintenceRequestRepo) {
            this.maintenceRequestRepo = maintenceRequestRepo;
        }

        @Override
        public MaintenceRequest create(MaintenceRequest maintenceRequest) throws ResourceCreationException {
            Optional<MaintenceRequest> optional = maintenceRequestRepo.findByEmail(maintenceRequest.getEmail());
            if(optional.isPresent())
                throw new ResourceCreationException("Maintenance Request with email exists: " + maintenceRequest.getEmail());
            maintenceRequest = maintenceRequestRepo.save(maintenceRequest);
            return maintenceRequest;
        }

        @Override
        public MaintenceRequest getById(Long id) throws ResourceNotFoundException {
            MaintenceRequest maintenceRequest = maintenceRequestRepo.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("No maintenance request with id: " + id));
            return maintenceRequest;
        }

        @Override
        public MaintenceRequest getByEmail(String email) throws ResourceNotFoundException {
            MaintenceRequest maintenceRequest = maintenceRequestRepo.findByEmail(email)
                    .orElseThrow(()->new ResourceNotFoundException("No maintenance request with email: " + email));
            return maintenceRequest;
        }

    @Override
    public MaintenceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = maintenceRequestRepo.findByAptNumber(aptNumber)
                .orElseThrow(() -> new ResourceNotFoundException("No maintenance request with Apt number: " + aptNumber));
        return maintenceRequest;
    }


    @Override
    public MaintenceRequest getByDescription(String description) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = maintenceRequestRepo.findByDescription(description)
                .orElseThrow(() -> new ResourceNotFoundException("No maintenance request with Description: " + description));
        return maintenceRequest;
    }

    @Override
        public List<MaintenceRequest> getAll() {
            return maintenceRequestRepo.findAll();
        }

        @Override
        public MaintenceRequest update(Long id, MaintenceRequest maintenanceRequestDetail) throws ResourceNotFoundException {
            MaintenceRequest maintenceRequest = getById(id);
            maintenceRequest.setFirstName(maintenanceRequestDetail.getFirstName());
            maintenceRequest.setLastName(maintenanceRequestDetail.getLastName());
            maintenceRequest.setEmail(maintenanceRequestDetail.getEmail());
            maintenceRequest.setAptNumber(maintenanceRequestDetail.getAptNumber());
            maintenceRequest.setDescription(maintenanceRequestDetail.getDescription());
            maintenceRequest.setCreateAt(maintenanceRequestDetail.getCreateAt());

            maintenceRequest = maintenceRequestRepo.save(maintenceRequest);
            return maintenceRequest;
        }

        @Override
        public void delete(Long id) {
            MaintenceRequest maintenceRequest = getById(id);
            maintenceRequestRepo.delete(maintenceRequest);
        }
    }

