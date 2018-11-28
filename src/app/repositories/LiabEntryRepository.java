package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.LiabEntry;

@Repository
public interface LiabEntryRepository extends JpaRepository<LiabEntry, Long>{

	List<LiabEntry> findByLiabId(Long liab_id);
}
