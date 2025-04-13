package com.jpacourse.mapper;

import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.dto.MedicalTreatmentTO;

import java.util.stream.Collectors;

public class VisitMapper {

    public static VisitTO toTO(VisitEntity entity) {
        if (entity == null) {
            return null;
        }

        return new VisitTO(
                entity.getTime().toLocalDate(),  // Zakładając, że `getTime()` zwraca `LocalDateTime`, konwertujemy to na `LocalDate`
                entity.getDoctor().getFirstName(),
                entity.getDoctor().getLastName(),
                entity.getTreatments().stream()
                        .map(t -> new MedicalTreatmentTO(t.getId(), t.getDescription(), t.getType().toString()))  // Mapowanie leczenia na typ String
                        .collect(Collectors.toList())
        );
    }
}