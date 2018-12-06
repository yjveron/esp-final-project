package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entity.LiabEntry;

@Repository
public interface LiabEntryRepository extends JpaRepository<LiabEntry, Long>{

	List<LiabEntry> findByLiabId(Long liabId);
	
	List<LiabEntry> findByVolId(Long volId);
	LiabEntry findById(Long id);


}
