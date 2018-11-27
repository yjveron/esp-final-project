package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.LiabEntry;

@Repository
public interface LiabEntryRepository extends JpaRepository<LiabEntry, Long>{

}
