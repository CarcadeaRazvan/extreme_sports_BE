package com.sports.backend.repository;

import com.sports.backend.model.County;
import com.sports.backend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(value = "SELECT c from Location c where c.countyId = :id")
    public List<Location> getLocationsByCounty(Long id);
}
