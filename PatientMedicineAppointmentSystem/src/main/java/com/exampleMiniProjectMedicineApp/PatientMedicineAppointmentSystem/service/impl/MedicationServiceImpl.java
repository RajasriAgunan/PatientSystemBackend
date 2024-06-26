package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.impl;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.MedicationDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Medication;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.exception.EmailAlreadyExistException;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper.MedicationMapper;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper.PatientMapper;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.repository.MedicationRepository;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.MedicationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.aot.AotServices;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicationServiceImpl implements MedicationService {
    private MedicationRepository medicationRepository;
    private ModelMapper modelMapper;
    @Override
    public MedicationDto createMedication(MedicationDto medicationDto) {
        Medication medication=modelMapper.map(medicationDto,Medication.class);

        return MedicationMapper.mapToMedicationDto(medicationRepository.save(medication));
}
@Override
    public List<MedicationDto> getAllMedications() {
    List<Medication> medications=medicationRepository.findAll();
    return  medications.stream().map(patient->modelMapper.map(medications, MedicationDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public MedicationDto getMedicationById(Long medicationId) {
        Medication medication= medicationRepository.findById(medicationId)
            .orElseThrow(()->new ResourceNotFoundException("Patient","id", medicationId));
        return modelMapper.map(medication,MedicationDto.class);

    }

    @Override
    public MedicationDto updateMedication(MedicationDto medicationDto) {
        Medication med=medicationRepository.findById(medicationDto.getId()).get();
        med.setMedicine_name(medicationDto.getMedication_name());
        med.setDosage(medicationDto.getDosage());
        med.setInstructions(medicationDto.getInstructions());
        return modelMapper.map(medicationRepository.save(med),MedicationDto.class);
    }

    @Override
    public void deleteMedication(Long id) {

    }
}
