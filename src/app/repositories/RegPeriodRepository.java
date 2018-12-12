package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.RegPeriod;

@Repository
public interface RegPeriodRepository extends JpaRepository<RegPeriod, Long> 
{
	RegPeriod findByRegTitle(String regTitle);
	List<RegPeriod> findById(Long id);
}
