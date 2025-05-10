package com.jpacourse.persistance.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jpacourse.persistance.entity.PatientEntity;

public interface PatientDao extends Dao<PatientEntity, Long> {

    PatientEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescription);

    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> findWithMoreThanXVisits(int numOfVisits);

    List<PatientEntity> findByRegistrationDateBetween(LocalDate startDate, LocalDate endDate);
}