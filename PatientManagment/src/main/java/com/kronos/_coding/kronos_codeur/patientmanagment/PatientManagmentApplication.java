package com.kronos._coding.kronos_codeur.patientmanagment;

import com.kronos._coding.kronos_codeur.patientmanagment.entities.Patient;
import com.kronos._coding.kronos_codeur.patientmanagment.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientManagmentApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientManagmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Kronos",new Date(), 2300, false));
		patientRepository.save(new Patient(null,"Arris",new Date(), 4000, false));
		patientRepository.save(new Patient(null,"Kronos_Codeur",new Date(), 6000, false));
		patientRepository.save(new Patient(null,"Codeur",new Date(), 2500, false));
		patientRepository.save(new Patient(null,"Youssouf",new Date(), 5230, true));
		patientRepository.save(new Patient(null,"Ahmed",new Date(), 6254, true));
		patientRepository.save(new Patient(null,"Mathieu",new Date(), 3200, true));
		System.out.println(".................................................");
		patientRepository.findAll().forEach(p -> {
			System.out.println(p.toString());
		});
		System.out.println(".................................................");
		Patient patient = patientRepository.findById(4L).get();
		System.out.println(patient.getNom());
		System.out.println(".................................................");
		Page<Patient> patients = patientRepository.findByNomContains("o", PageRequest.of(0,3));
		patients.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		System.out.println(".................................................");
		List<Patient> patients2 = patientRepository.findByMalade(false);
		patients2.forEach(p -> {
			System.out.println(p.toString());
		});
		System.out.println(".................................................");
		List<Patient> patients3 = patientRepository.findByNomContainsAndMalade("a" ,true);
		patients3.forEach(p -> {
			System.out.println(p.toString());
		});
		patientRepository.deleteById(4L);
		System.out.println(".................................................");
		Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(0,2));
		System.out.println("Nombres de pages : "+pagePatients.getTotalPages());
		List<Patient>listPatients = pagePatients.getContent();
		listPatients.forEach(p -> {
			System.out.println(p.toString());
		});
	}
}
