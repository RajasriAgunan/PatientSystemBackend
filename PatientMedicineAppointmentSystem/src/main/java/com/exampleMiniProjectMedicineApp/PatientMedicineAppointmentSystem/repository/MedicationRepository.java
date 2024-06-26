package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.repository;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface MedicationRepository extends JpaRepository<Medication,Long> {

}
