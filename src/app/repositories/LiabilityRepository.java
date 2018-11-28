package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Liability;

@Repository
public interface LiabilityRepository extends JpaRepository<Liability, Long> {
	
	//Get the information of that Liability if searching through LiabEntry
	Liability findById(Long id);
	Liability findByTitle(String title);
	
	
}
