package com.jpacourse.mapper;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.dto.MedicalTreatmentTO;

import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientTO mapToTO(PatientEntity entity) {
        return new PatientTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getTelephoneNumber(),
                entity.getPatientNumber(),
                entity.getDateOfBirth(),
                entity.getAge(),
                entity.getVisits().stream()
                        .map(PatientMapper::mapVisitToTO)
                        .collect(Collectors.toList())
        );
    }

    private static VisitTO mapVisitToTO(VisitEntity visit) {
        return new VisitTO(
                visit.getTime().toLocalDate(),  // Zakładając, że getTime() zwraca LocalDateTime, konwertujemy na LocalDate
                visit.getDoctor().getFirstName(),
                visit.getDoctor().getLastName(),
                visit.getTreatments().stream()
                        .map(t -> new MedicalTreatmentTO(t.getId(), t.getDescription(), t.getType().toString())) // Używamy toString() dla typu leczenia
                        .collect(Collectors.toList())  // Zbiera wyniki do listy
        );
    }
}