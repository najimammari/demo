package ma.gov.douane.sdawsd.devises.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.gov.douane.sdawsd.devises.model.Compte;
import ma.gov.douane.sdawsd.devises.repository.CompteRepository;

//@RestController
public class CompteRestController {

	private CompteRepository compteRepository;

	public CompteRestController(CompteRepository compteRepository) {
		super();
		this.compteRepository = compteRepository;
	}
	
	@GetMapping("/comptes")
	public List<Compte> listComptes(){
		return compteRepository.findAll();
	}
	
	@GetMapping("/comptes/{code}")
	public Compte comptes(@PathVariable Long code){
		return compteRepository.findById(code).get();
	}
	
	@PostMapping("/comptes")
	public Compte save(@RequestBody Compte compte){
		return compteRepository.save(compte);
	}
	
	@PutMapping("/comptes/{code}")
	public Compte update(@PathVariable Long code, @RequestBody Compte compte){
		compte.setCode(code);
		return compteRepository.save(compte);
	}
	
	@DeleteMapping("/comptes/{code}")
	public void delete(@PathVariable Long code){
		compteRepository.deleteById(code);
	}

}
