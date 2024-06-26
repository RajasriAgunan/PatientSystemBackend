package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.mapper;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.AppointmentDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Appointment;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;

public class AppointmentMapper {
    public static AppointmentDto maptoAppointmentDto(Appointment appointment){
        AppointmentDto appointmentDto=new AppointmentDto();
        appointmentDto.setId(appointment.getId());
        appointment.setAppointmentTime(appointment.getAppointmentTime());
        appointmentDto.setPatientId(appointment.getPatients().getId());
        appointmentDto.setDoctorId(appointment.getDoctors().getId());
        return appointmentDto;

    }
    public static Appointment mapToAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDto.getId());
        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());

        // For simplicity, assuming the patient and doctor are set elsewhere
        Patient patient = new Patient();
        patient.setId(appointmentDto.getPatientId());
        appointment.setPatients(patient);

        Doctor doctor = new Doctor();
        doctor.setId(appointmentDto.getDoctorId());
        appointment.setDoctors(doctor);

        return appointment;
    }
}
