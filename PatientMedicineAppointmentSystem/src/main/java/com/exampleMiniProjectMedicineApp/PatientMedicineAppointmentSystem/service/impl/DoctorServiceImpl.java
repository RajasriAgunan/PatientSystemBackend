package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.impl;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.DoctorDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.MedicationDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper.DoctorMapper;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.repository.DoctorRepository;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    public DoctorRepository doctorRepository;
    private ModelMapper modelMapper;

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor=modelMapper.map(doctorDto,Doctor.class);
        return DoctorMapper.mapToDoctorDto(doctorRepository.save(doctor));
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors=doctorRepository.findAll();
        return  doctors.stream().map(doctor->modelMapper.map(doctors, DoctorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {
        Doctor doctor= doctorRepository.findById(doctorId)
                .orElseThrow(()->new ResourceNotFoundException("Patient","id", doctorId));
        return modelMapper.map(doctor,DoctorDto.class);

    }

    public DoctorDto updateDoctor(DoctorDto doctorDto) {
        Doctor doc= doctorRepository.findById(doctorDto.getId()).get();
        doc.setName(doctorDto.getName());
        doc.setSpecialization(doctorDto.getSpecialization());
        doc.setEmail(doctorDto.getEmail());
        doc.setDegree(doctorDto.getDegree());
        return modelMapper.map(doctorRepository.save(doc),DoctorDto.class);

    }

    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);

    }
}
