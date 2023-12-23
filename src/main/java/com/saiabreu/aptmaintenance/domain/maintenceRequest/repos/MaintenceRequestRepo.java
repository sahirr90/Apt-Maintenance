package com.saiabreu.aptmaintenance.domain.maintenceRequest.repos;

import com.saiabreu.aptmaintenance.domain.maintenceRequest.models.MaintenceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenceRequestRepo extends JpaRepository<MaintenceRequest, Long> {
        Optional<MaintenceRequest> findByEmail(String email);

        Optional<MaintenceRequest> findByAptNumber(String aptNumber);

        Optional<MaintenceRequest> findByDescription(String description);



}