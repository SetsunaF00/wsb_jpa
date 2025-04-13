package com.jpacourse.service;

import com.jpacourse.persistance.dao.PatientRepository;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.dto.PatientTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::mapToTO)
                .collect(Collectors.toList());
    }

    public PatientTO getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(PatientMapper::mapToTO)
                .orElse(null);
    }
}