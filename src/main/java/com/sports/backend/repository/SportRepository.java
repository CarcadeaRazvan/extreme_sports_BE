package com.sports.backend.repository;

import com.sports.backend.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
    @Query(value = "SELECT s from Sport s where s.locationId = :id")
    public List<Sport> getSportsByLocation(Long id);

    @Query(value = "SELECT s from Sport s where s.name in :names and s.startingDate <= :startingDate and s.endingDate >= :endingDate")
    public List<Sport> getSportsByNameAndDate(List<String> names, LocalDate startingDate, LocalDate endingDate);

    @Query(value = "SELECT s from Sport s where s in :sports and s.location.name = :place")
    public List<Sport> getSportsByLocationName(List<Sport> sports, String place);

    @Query(value = "SELECT s from Sport s where s in :sports and s.location.county.name = :place")
    public List<Sport> getSportsByCountyName(List<Sport> sports, String place);

    @Query(value = "SELECT s from Sport s where s in :sports and s.location.county.country.name = :place")
    public List<Sport> getSportsByCountryName(List<Sport> sports, String place);
}
