package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.DoctorDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;

public class DoctorMapper {
    public static DoctorDto mapToDoctorDto(Doctor doctor) {
    DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setDegree(doctor.getDegree());

        return doctorDto;
}

    public static Doctor mapToDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setDegree(doctorDto.getDegree());
        return doctor;
    }
}
