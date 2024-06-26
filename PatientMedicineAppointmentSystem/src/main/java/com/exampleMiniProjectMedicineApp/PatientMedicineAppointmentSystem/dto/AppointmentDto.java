package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;
    @NotEmpty(message = "Date and time must not be empty")
    private LocalDateTime appointmentTime;
    private Long patientId;
    private Long doctorId;

}
