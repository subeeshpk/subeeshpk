package com.doctor.dosage.controller;

import com.doctor.dosage.model.Dosage;
import com.doctor.dosage.exception.ResourceNotFoundException;
import com.doctor.dosage.repository.DosageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by subeeshpk on 07/02/21.
 */
@RestController
@RequestMapping("/api")
public class DosageServiceController {

    @Autowired
    DosageRepository dosageRepository;

    @GetMapping("/dosage")
    public List<Dosage> getAllDosages() {
        return dosageRepository.findAll();
    }

    @GetMapping("/dosagesample")
    public Dosage getSampleDosages() {
        Dosage n = new Dosage();
        n.setContent("Tesst");
        n.setTitle("test title");
        return n;
    }

    @PostMapping("/dosage")
    public Dosage createDosage(@Valid @RequestBody Dosage dosage) {
        return dosageRepository.save(dosage);
    }

    @GetMapping("/dosage/{id}")
    public Dosage getDosageById(@PathVariable(value = "id") Long dosageId) {
        return dosageRepository.findById(dosageId)
                .orElseThrow(() -> new ResourceNotFoundException("Dosage", "id", dosageId));
    }

    @PutMapping("/dosage/{id}")
    public Dosage updateDosage(@PathVariable(value = "id") Long dosageId,
                                           @Valid @RequestBody Dosage dosageDetails) {

        Dosage dosage = dosageRepository.findById(dosageId)
                .orElseThrow(() -> new ResourceNotFoundException("Dosage", "id", dosageId));

        dosage.setTitle(dosageDetails.getTitle());
        dosage.setContent(dosageDetails.getContent());

        Dosage updatedDosage = dosageRepository.save(dosage);
        return updatedDosage;
    }

    @DeleteMapping("/dosage/{id}")
    public ResponseEntity<?> deleteDosage(@PathVariable(value = "id") Long dosageId) {
        Dosage dosage = dosageRepository.findById(dosageId)
                .orElseThrow(() -> new ResourceNotFoundException("Dosage", "id", dosageId));

        dosageRepository.delete(dosage);

        return ResponseEntity.ok().build();
    }
}
