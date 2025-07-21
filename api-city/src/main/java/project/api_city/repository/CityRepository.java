package project.api_city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.api_city.model.CityModel;

import java.util.Optional;

public interface CityRepository extends JpaRepository<CityModel, Long> {
    Optional<CityModel> findByName(String name);
}

