package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.impl;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.exception.EmailAlreadyExistException;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper.PatientMapper;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.repository.PatientRepository;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.PatientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public  class PatientServiceImpl implements PatientService{

  private PatientRepository patientRepository;
    private ModelMapper modelMapper;
    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient=modelMapper.map(patientDto,Patient.class);
        Optional<Patient> optionalPatient=patientRepository.findByEmail(patient.getEmail());
        if(optionalPatient.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist for Patient");
        }
        return PatientMapper.maptoPatientDto(patientRepository.save(patient));

    }


    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients=patientRepository.findAll();
        return  patients.stream().map(patient->modelMapper.map(patients,PatientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(Long patientId) {
        Patient patient= patientRepository.findById(patientId)
                .orElseThrow(()->new ResourceNotFoundException("Patient","id", patientId));
        return modelMapper.map(patient,PatientDto.class);
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto) {
        Patient pat = patientRepository.findById(patientDto.getId()).get();
        pat.setName(patientDto.getName());
        pat.setEmail(patientDto.getEmail());
        pat.setPhone(patientDto.getPhone());
        pat.setAddress(patientDto.getAddress());
        return modelMapper.map(patientRepository.save(pat),PatientDto.class);
    }

    @Override
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);

    }

    @Override
    public Optional<Patient> findById(Long id) {

            return patientRepository.findById(id);
        }
    }

