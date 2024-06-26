package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationDto {
    private Long id;
    @NotEmpty(message = "name must not be empty")
    private String Medication_name;
    @NotEmpty(message ="dosage must not be empty")
    private String dosage;
    @NotEmpty(message = "instructions must not be empty")
    private String instructions;
    private Long patientId;


}
