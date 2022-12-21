package ma.gov.douane.sdawsd.devises.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ma.gov.douane.sdawsd.devises.model.Compte;
import ma.gov.douane.sdawsd.devises.model.TypeCompte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long>{

	@RestResource(path = "/byType")
	public List<Compte> findByType(TypeCompte type);
}
