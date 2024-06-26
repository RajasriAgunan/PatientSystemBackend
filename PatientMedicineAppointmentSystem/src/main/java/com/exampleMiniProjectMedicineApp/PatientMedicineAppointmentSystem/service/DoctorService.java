package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.DoctorDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);
    List<DoctorDto> getAllDoctors();
    DoctorDto getDoctorById(Long id);
    DoctorDto updateDoctor(DoctorDto doctorDto);
    void deleteDoctor(Long doctorId);

}
