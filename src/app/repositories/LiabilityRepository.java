package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Liability;

@Repository
public interface LiabilityRepository extends JpaRepository<Liability, Long> {

}
