package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.impl;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.AppointmentDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Appointment;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper.AppointmentMapper;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.repository.AppointmentRepository;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
 private AppointmentRepository appointmentRepository;
    private ModelMapper modelMapper;

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto)
    {
        Appointment appointment=modelMapper.map(appointmentDto,Appointment.class);

        return AppointmentMapper.maptoAppointmentDto(appointmentRepository.save(appointment));
    }

    public List<AppointmentDto> getAppointmentsByDate(LocalDateTime start, LocalDateTime end) {
        List<Appointment> appointments=appointmentRepository.findByAppointmentTimeBetween(start, end);
        return  appointments.stream().map(patient->modelMapper.map(appointments, AppointmentDto.class))
                .collect(Collectors.toList());
    }

        public AppointmentDto getAppointmentById(Long appointmentId) {
            Appointment appointment= appointmentRepository.findById(appointmentId)
                    .orElseThrow(()->new ResourceNotFoundException("Appointment","id", appointmentId));
            return modelMapper.map(appointment, AppointmentDto.class);

    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
