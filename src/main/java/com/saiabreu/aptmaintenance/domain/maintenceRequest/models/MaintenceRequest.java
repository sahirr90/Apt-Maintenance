package com.saiabreu.aptmaintenance.domain.maintenceRequest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString

public class MaintenceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String aptNumber;

    @NonNull
    private String description;

    @NonNull
    private Date createAt;

//         @Override
//    public String toString(){
//             return String.format("First name: %s, Last name: %s, Email: %s, Apt Number: %s, Description: %s, and Date: %s ", firstName, lastName, email, aptNumber, description, createAt );
//         }

}
