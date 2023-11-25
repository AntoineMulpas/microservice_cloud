package com.medilabo.microservice_cloud.proxies;

import com.medilabo.microservice_cloud.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name = "microservice-patients")
public interface PatientProxy {

    @GetMapping("/all")
    List<PatientBean> findAllPatient();

    @PostMapping(path = "/add", consumes = "application/json")
    PatientBean addNewPatient(PatientBean patientBean);

    @GetMapping("/{id}")
    PatientBean findPatientById(@PathVariable  Long id);

    @GetMapping("/delete/{id}")
    String deletePatientById(@PathVariable Long id);

    @PostMapping(path = "/update/{id}")
    PatientBean updatePatientById(@PathVariable Long id, @RequestBody PatientBean patientBean);

}



