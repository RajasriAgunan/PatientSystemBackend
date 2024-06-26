package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.AppointmentDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> getAppointmentsByDate(LocalDateTime startDateTime, LocalDateTime endDateTime);

    AppointmentDto getAppointmentById(Long appointmentId);

        void deleteAppointment(Long appointmentId);


}
