package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.RegDay;

@Repository
public interface RegDayRepository extends JpaRepository<RegDay, Long> {

}
