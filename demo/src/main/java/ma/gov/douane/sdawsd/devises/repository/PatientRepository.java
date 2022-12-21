package ma.gov.douane.sdawsd.devises.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.gov.douane.sdawsd.devises.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	public Page<Patient> findPatientByNomContains(String name,Pageable pageable);
	public List<Patient> findPatientByMalade(boolean b);
	public List<Patient> findPatientByNomContainsAndMalade(String name,boolean b);
}
