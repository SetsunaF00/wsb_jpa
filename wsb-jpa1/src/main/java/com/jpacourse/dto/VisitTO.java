package com.jpacourse.dto;

import java.time.LocalDate;
import java.util.List;

public class VisitTO {
    private LocalDate date;
    private String doctorFirstName;
    private String doctorLastName;
    private List<MedicalTreatmentTO> treatments;  // Zmienione z List<String> na List<MedicalTreatmentTO>

    public VisitTO(LocalDate date, String doctorFirstName, String doctorLastName, List<MedicalTreatmentTO> treatments) {
        this.date = date;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.treatments = treatments;
    }

    // Gettery i Settery

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public List<MedicalTreatmentTO> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentTO> treatments) {
        this.treatments = treatments;
    }
}