package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.repository;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
