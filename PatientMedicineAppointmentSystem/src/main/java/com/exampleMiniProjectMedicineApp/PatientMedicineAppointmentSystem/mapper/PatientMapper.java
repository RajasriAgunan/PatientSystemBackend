package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;

public class PatientMapper {
    public static PatientDto maptoPatientDto(Patient patient){
        PatientDto patientDto=new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setPhone(patient.getPhone());
        patientDto.setAddress(patient.getAddress());
        patientDto.setDisease(patient.getDisease());
        return patientDto;
    }
    public static Patient maptoEmployee(PatientDto patientDto){
       Patient patient=new Patient();
        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone(patientDto.getPhone());
        patient.setAddress(patientDto.getAddress());
        patient.setDisease(patientDto.getDisease());
        return patient;

    }
}
