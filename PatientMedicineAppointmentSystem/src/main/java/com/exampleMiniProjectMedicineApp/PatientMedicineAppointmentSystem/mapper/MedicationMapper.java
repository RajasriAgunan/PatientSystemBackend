package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.MedicationDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Medication;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;

public class MedicationMapper {
    public static MedicationDto mapToMedicationDto(Medication medication) {
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setId(medication.getId());
        medicationDto.setMedication_name(medication.getMedicine_name());
        medicationDto.setDosage(medication.getDosage());
        medicationDto.setInstructions(medication.getInstructions());
        medicationDto.setPatientId(medication.getPatients().getId());
        return medicationDto;
    }

    public static Medication mapToMedication(MedicationDto medicationDto) {
        Medication medication = new Medication();
        medication.setId(medicationDto.getId());
        medication.setMedicine_name(medicationDto.getMedication_name());
        medication.setDosage(medicationDto.getDosage());
        medication.setInstructions(medicationDto.getInstructions());

        Patient patient = new Patient();
        patient.setId(medicationDto.getPatientId());
        medication.setPatients(patient);


        return medication;
    }
}