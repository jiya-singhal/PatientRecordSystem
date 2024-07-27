package com.example.patientrecordsystem.Contoller;


import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.example.patientrecordsystem.Models.Patient;
import com.example.patientrecordsystem.Service.PatientServiceInterface;



@RestController
@RequestMapping("/patients")
@Slf4j
public class PatientController {
    private final PatientServiceInterface patientServiceInterface;
    public PatientController(PatientServiceInterface patientServiceInterface) {
        this.patientServiceInterface = patientServiceInterface;
    }
    @GetMapping
    public List<Patient> getAllPatients() {
        log.info("Got all patients");
        return patientServiceInterface.getAllPatients();
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        log.info("Got patient by id");
        return patientServiceInterface.getPatientById(id);
    }
    @PutMapping
    public Patient addPatient(@RequestBody Patient patient) {
        log.info("Added patient");
        return patientServiceInterface.addPatient(patient);
    }
    @DeleteMapping("/{id}")
    public  void deletePatient(@PathVariable("id") Long id) {
        log.info("Deleted patient");
        patientServiceInterface.deletePatient(id);
    }
}
