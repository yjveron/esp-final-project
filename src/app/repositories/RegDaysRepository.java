package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.RegDays;

@Repository
public interface RegDaysRepository extends JpaRepository<RegDays, Long> {

}
