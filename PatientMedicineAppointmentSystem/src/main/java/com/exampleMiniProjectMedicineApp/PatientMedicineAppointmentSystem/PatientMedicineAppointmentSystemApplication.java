package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.AppointmentDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.DoctorDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.MedicationDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Appointment;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Medication;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PatientMedicineAppointmentSystemApplication {
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.createTypeMap(AppointmentDto.class, Appointment.class)
				.addMapping(AppointmentDto::getId,Appointment::setAppointmentTime)
				.addMapping(AppointmentDto::getAppointmentTime,Appointment::setAppointmentTime)
				.addMapping(AppointmentDto::getPatientId,Appointment::setPatients)
				.addMapping(AppointmentDto::getDoctorId,Appointment::setDoctors);
		modelMapper.createTypeMap(DoctorDto.class, Doctor.class)
				.addMapping(DoctorDto::getId,Doctor::setId)
				.addMapping(DoctorDto::getId,Doctor::setName)
				.addMapping(DoctorDto::getName,Doctor::setName)
				.addMapping(DoctorDto::getEmail,Doctor::setEmail)
				.addMapping(DoctorDto::getSpecialization,Doctor::setSpecialization)
				.addMapping(DoctorDto::getEmail,Doctor::setEmail)
				.addMapping(DoctorDto::getDegree,Doctor::setDegree);
		modelMapper.createTypeMap(MedicationDto.class, Medication.class)
				.addMapping(MedicationDto::getId, Medication::setMedicine_name)
				.addMapping(MedicationDto::getMedication_name,Medication::setMedicine_name)
				.addMapping(MedicationDto::getDosage,Medication::setDosage)
				.addMapping(MedicationDto::getInstructions,Medication::setDosage);
		modelMapper.createTypeMap(PatientDto.class, Patient.class)
				.addMapping(PatientDto::getId,Patient::setName)
				.addMapping(PatientDto::getName,Patient::setName)
				.addMapping(PatientDto::getEmail,Patient::setEmail)
				.addMapping(PatientDto::getPhone,Patient::setPhone)
				.addMapping(PatientDto::getAddress,Patient::setAddress)
				.addMapping(PatientDto::getDisease,Patient::setDisease);

		return  modelMapper;
	}


	public static void main(String[] args) {
		SpringApplication.run(PatientMedicineAppointmentSystemApplication.class, args);
	}

}
