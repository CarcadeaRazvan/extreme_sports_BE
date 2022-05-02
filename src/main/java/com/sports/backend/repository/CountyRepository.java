package com.sports.backend.repository;

import com.sports.backend.model.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {
    @Query(value = "SELECT c from County c where c.countryId = :id")
    public List<County> getCountiesByCountry(Long id);
}
