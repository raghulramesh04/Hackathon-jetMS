package ManufactureJet.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ManufactureJet.application.Entity.JetOrderEntity;

public interface JetOrderRepository extends JpaRepository<JetOrderEntity,Integer> {
	
}
