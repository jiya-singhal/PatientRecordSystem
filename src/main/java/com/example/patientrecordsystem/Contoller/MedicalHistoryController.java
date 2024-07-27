package com.example.patientrecordsystem.Contoller;

import com.example.patientrecordsystem.Models.Appointment;
import com.example.patientrecordsystem.Models.MedicalHistory;
import com.example.patientrecordsystem.Service.MedicalHistoryServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/history")
@Slf4j
public class MedicalHistoryController {
    private final MedicalHistoryServiceInterface medicalHistoryServiceInterface;

    public MedicalHistoryController(MedicalHistoryServiceInterface medicalHistoryServiceInterface) {
        this.medicalHistoryServiceInterface = medicalHistoryServiceInterface;
    }
    @GetMapping
    public List<MedicalHistory> getAllHistory() {
        log.info("Got all history");
        return medicalHistoryServiceInterface.getAllHistory();
    }
    @GetMapping("/{patientId}")
    public List<MedicalHistory> getAllHistoryByPatientId(@PathVariable("patientId") Long patientId) {
        log.info("Got all history by patient id");
        return medicalHistoryServiceInterface.getAllHistoryByPatientId(patientId);
    }
    @PutMapping()
    public MedicalHistory addHistory(@RequestBody MedicalHistory medicalHistory) {
        log.info("Added history");
        return medicalHistoryServiceInterface.addHistory(medicalHistory);
    }
    @DeleteMapping("/{id}")
    public void deleteHistory(@PathVariable("id") Long id) {
        log.info("Deleted history");
        medicalHistoryServiceInterface.deleteHistory(id);
    }
}
