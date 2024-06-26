package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.controller;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.AppointmentDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Appointment;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Medication;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/appointments")
@AllArgsConstructor
public class AppointmentController {
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentDto saveAppointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(saveAppointment, HttpStatus.CREATED);
    } 

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByDate(@RequestParam String date) {
        LocalDateTime startDateTime = LocalDate.parse(date, DateTimeFormatter.ISO_DATE).atStartOfDay();
        LocalDateTime endDateTime = startDateTime.plusDays(1).minusNanos(1);
        List<AppointmentDto> appointments = appointmentService.getAppointmentsByDate(startDateTime, endDateTime);
        return ResponseEntity.ok(appointments);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable("id") Long id) {
        AppointmentDto appointment = appointmentService.getAppointmentById(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);


    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);

    }
}