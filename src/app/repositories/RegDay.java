package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegDay extends JpaRepository<app.entity.RegDay, Long> {

}
