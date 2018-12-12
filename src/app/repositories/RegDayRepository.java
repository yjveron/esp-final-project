package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entity.RegDay;

@Repository
public interface RegDayRepository extends JpaRepository<RegDay, Long>{

	List<RegDay> findByDayType(String DayType);
	List<RegDay> findByRegPeriodId(Long id);
	RegDay findByRegTitle(String regTitle);
	@Query("select u from RegDay u where u.id = ?1")
	RegDay findBySpecRegDay(Long id);

}
