package com.kronos._coding.kronos_codeur.patientmanagment.repositories;

import com.kronos._coding.kronos_codeur.patientmanagment.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Page<Patient> findByNomContains(String name, Pageable pageable);
    public List<Patient> findByMalade(Boolean B);
    public List<Patient> findByNomContainsAndMalade(String name, Boolean B);
}
