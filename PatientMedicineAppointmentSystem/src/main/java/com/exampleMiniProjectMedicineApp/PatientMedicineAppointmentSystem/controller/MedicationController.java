package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.controller;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.MedicationDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Medication;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.MedicationService;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/medications")
@AllArgsConstructor
public class MedicationController {
    private MedicationService medicationService;
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto medicationDto) {
        MedicationDto saveMedication = medicationService.createMedication(medicationDto);
        return ResponseEntity.ok(saveMedication);
    }



    @GetMapping
    public ResponseEntity<List<MedicationDto>> getAllMedications() {
        List<MedicationDto> medications = medicationService.getAllMedications();
        return  ResponseEntity.ok().body(medications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDto>  getMedication(@PathVariable("id") Long id) {
        MedicationDto medication= medicationService.getMedicationById(id);
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MedicationDto> updateMedication(@PathVariable Long id,
                                                          @RequestBody MedicationDto medicationDto) {
        medicationDto.setId(id);
        MedicationDto  updateMedication =medicationService.updateMedication(medicationDto);
        return new ResponseEntity<>(updateMedication, HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMedication(@PathVariable("id") Long id) {
        medicationService.deleteMedication(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }
}


