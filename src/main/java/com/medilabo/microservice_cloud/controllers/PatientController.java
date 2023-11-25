package com.medilabo.microservice_cloud.controllers;

import com.medilabo.microservice_cloud.beans.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    private RestTemplate restTemplate;

    private LoadBalancerClient loadBalancerClient;

    @Autowired
    public PatientController(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping("/all")
    public ResponseEntity <List<PatientBean>> findAllPatient() {
        System.out.println("called cloud controller.");
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-patients");
        URI uri = serviceInstance.getUri();
        String url = uri + "/api/v1/patient/all";

        ResponseEntity <PatientBean[]> response =
                restTemplate.getForEntity(
                        url,
                        PatientBean[].class);
        PatientBean[] patientBeans = response.getBody();
        List <PatientBean> pb = new ArrayList <>(Arrays.asList(patientBeans));
        return ResponseEntity.ok().body(pb);
    }

    /*
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

     */

}
