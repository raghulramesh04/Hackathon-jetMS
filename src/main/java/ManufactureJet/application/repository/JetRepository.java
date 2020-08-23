package ManufactureJet.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ManufactureJet.application.Entity.JetEntity;

@Repository
public interface JetRepository extends JpaRepository<JetEntity,String>{
	
	JetEntity findBymodelName(String modelName);

}
