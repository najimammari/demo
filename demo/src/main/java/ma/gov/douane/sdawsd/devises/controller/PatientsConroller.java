package ma.gov.douane.sdawsd.devises.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ma.gov.douane.sdawsd.devises.model.Patient;
import ma.gov.douane.sdawsd.devises.repository.PatientRepository;

@RestController
public class PatientsConroller {

	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping("/patients")
	public List<Patient> patients(){
		return patientRepository.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public Patient patients(@PathVariable Long id){
		return patientRepository.findById(id).get();
	}
}
