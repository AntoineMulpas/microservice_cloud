package com.medilabo.microservice_cloud.controllers;

import com.medilabo.microservice_cloud.beans.PatientBean;
import com.medilabo.microservice_cloud.proxies.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    private PatientProxy patientProxy;

    @Autowired
    public PatientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }


    @GetMapping("/all")
    public ResponseEntity<List <PatientBean>> findAllPatient() {
        List <PatientBean> patients = patientProxy.findAllPatient();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public ResponseEntity<PatientBean> addNewPatient(
            @RequestBody PatientBean patientBean
    ) {
        PatientBean patient = patientProxy.addNewPatient(patientBean);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientBean> findPatientById(
            @PathVariable Long id
    ) {
        PatientBean patient = patientProxy.findPatientById(id);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deletePatientById(
            @PathVariable Long id
    ) {
        patientProxy.deletePatientById(id);
        return ResponseEntity.ok().body("Patient deleted with success.");
    }


    @PostMapping(value = "/update/{id}" , consumes = "application/JSON")
    public ResponseEntity<PatientBean> updatePatientById(
            @PathVariable Long id,
            @RequestBody PatientBean patient) {
        try {
            PatientBean updateById = patientProxy.updatePatientById(id, patient);
            return ResponseEntity.ok().body(updateById);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
