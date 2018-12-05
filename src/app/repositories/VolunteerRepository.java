package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.LiabEntry;
import app.entity.Liability;
import app.entity.Volunteer;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

	
	List<Volunteer> findByVolId(Long VolId);

}
