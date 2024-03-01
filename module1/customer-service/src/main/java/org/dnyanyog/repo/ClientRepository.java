package org.dnyanyog.repo;

import org.dnyanyog.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ClientRepository extends JpaRepository<Client,Long>{
	
	

}
