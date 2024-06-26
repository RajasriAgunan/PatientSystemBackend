package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);
    List<PatientDto> getAllPatients();
    PatientDto getPatientById(Long patientId);
    PatientDto updatePatient(PatientDto patientDto);

    void deletePatient(Long patientId);

    Optional<Patient> findById(Long id);


}
