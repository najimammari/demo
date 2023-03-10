package ma.gov.douane.sdawsd.devises.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Compte.class)
public interface CompteProj1 {

	public Long getCode();
	public double getSolde();
}
