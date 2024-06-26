package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.controller;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.PatientDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody @Valid PatientDto patientDto) {
        PatientDto savePatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(savePatient, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllEmployees() {
        List<PatientDto> patients = patientService.getAllPatients();
        return  ResponseEntity.ok().body(patients);
    }



        @GetMapping("/{id}")
            public ResponseEntity<PatientDto>  getEmployee(@PathVariable("id") Long id) {
                PatientDto patient = patientService.getPatientById(id);
                return new ResponseEntity<>(patient, HttpStatus.OK);

            }


        @PutMapping("/{id}")
        public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id,
                                                     @RequestBody @Valid PatientDto patientDto) {
            patientDto.setId(id);
            PatientDto updatePatient =patientService.updatePatient(patientDto);
            return new ResponseEntity<>(updatePatient, HttpStatus.OK);

        }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }
    }
