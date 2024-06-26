package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.MedicationDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Medication;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface MedicationService {
    MedicationDto createMedication(MedicationDto medicationDto);
    List<MedicationDto> getAllMedications();
    MedicationDto getMedicationById(Long medicationId);
    MedicationDto updateMedication(MedicationDto medicationDto);
    void deleteMedication(Long id);



}
