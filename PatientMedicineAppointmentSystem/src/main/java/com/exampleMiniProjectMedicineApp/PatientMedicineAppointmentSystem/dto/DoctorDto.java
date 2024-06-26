package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotEmpty(message = "specialization must not be empty")
    private String specialization;
    @NotEmpty(message = "email must not be empty")
    @Email
    private String email;
    @NotEmpty(message = "degree must not be empty")
    private String degree;

}
