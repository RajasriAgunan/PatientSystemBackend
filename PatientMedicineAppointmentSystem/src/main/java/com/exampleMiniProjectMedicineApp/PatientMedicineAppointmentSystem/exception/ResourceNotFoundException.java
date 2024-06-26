package com.exampleMiniProjectMedicineApp.PatientMedicineAppointmentSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


    @ResponseStatus(value = HttpStatus.NOT_FOUND)

    public class ResourceNotFoundException extends RuntimeException {

        private String resourceName;
        private String fieldName;
        private Long fieldValue;

        public ResourceNotFoundException(String resourceName){
            super(" " + resourceName + " not found with " );
            this.resourceName=resourceName;
        }

        public ResourceNotFoundException(String patient, String id, Long patientId) {
        }
    }

