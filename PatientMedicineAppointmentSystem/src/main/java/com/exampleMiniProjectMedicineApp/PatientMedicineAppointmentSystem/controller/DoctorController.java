package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.controller;

import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.dto.DoctorDto;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Doctor;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.entity.Patient;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.DoctorService;
import com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDto> createPatient(@RequestBody DoctorDto doctorDto) {
        DoctorDto saveDoctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(saveDoctor, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        return  ResponseEntity.ok().body(doctors);
    }



    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto>  getEmployee(@PathVariable("id") Long id) {
        DoctorDto doctor= doctorService.getDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updatePatient(@PathVariable Long id,
                                                 @RequestBody DoctorDto doctorDto) {
        doctorDto.setId(id);
        DoctorDto  updateDoctor =doctorService.updateDoctor(doctorDto);
        return new ResponseEntity<>(updateDoctor, HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }
}



