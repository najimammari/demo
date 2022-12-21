package ma.gov.douane.sdawsd.devises;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ma.gov.douane.sdawsd.devises.model.Compte;
import ma.gov.douane.sdawsd.devises.model.Patient;
import ma.gov.douane.sdawsd.devises.repository.PatientRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repositoryRestConfiguration.exposeIdsFor(Compte.class);
		
//		patientRepository.save(new Patient(null,"hassan",new Date(),25,false));
//		
//		patientRepository.save(new Patient(null,"ali",new Date(),253,true));
//		patientRepository.save(new Patient(null,"mohamed",new Date(),654,true));
//		patientRepository.save(new Patient(null,"lamyae",new Date(),674,false));
//		patientRepository.save(new Patient(null,"hassan",new Date(),275,false));
		
		System.out.println("****************************");
		patientRepository.findAll().forEach(System.out::println);
		
		System.out.println("******************************");
		Patient p = patientRepository.findById(4L).get();
		
		System.out.println(p.toString());
		
		System.out.println("****************************mmmmmmmmmmmmm");
		
		Page<Patient> patients = patientRepository.findPatientByNomContains("h",PageRequest.of(0, 2));
		
		patients.getContent().forEach(System.out::println);
		
		System.out.println("****************************");
		
		patientRepository.findPatientByMalade(true).forEach(System.out::println);
		
		System.out.println("****************************");
		
		patientRepository.findPatientByNomContainsAndMalade("h", true).forEach(System.out::println);
		
		//patientRepository.deleteById(5L);
		
		
		System.out.println("****************************");
		Page<Patient> pagePatient = patientRepository.findAll(PageRequest.of(1, 2));
		System.out.println("nombres de pages: "+pagePatient.getTotalPages());
		pagePatient.getContent().forEach(System.out::println);
		
	}

}
