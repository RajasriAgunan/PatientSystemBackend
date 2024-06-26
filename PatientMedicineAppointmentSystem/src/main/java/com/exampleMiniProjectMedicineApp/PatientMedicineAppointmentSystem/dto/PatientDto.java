package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long id;
   @NotEmpty(message = "name must not be empty")
    private String name;
    @NotEmpty(message = "email must not be empty")
    @Email
    private String email;
    @NotNull(message = "phone number must not be empty")
    private long phone;
    @NotEmpty(message = "address must not be empty")
    private String address;
    @NotEmpty(message = "disease must not be empty")
    private String disease;
}
