package com.sports.backend.service;

import com.sports.backend.model.Sport;
import com.sports.backend.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SportService {
    private final SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public void addSport(Sport sport) {
        sportRepository.save(sport);
    }

    public List<Sport> getSports() {
        return sportRepository.findAll();
    }

    public void deteleSport(Long id) {
        sportRepository.deleteById(id);
    }

    public void updateSport(Sport sport) {
        sportRepository.save(sport);
    }

    public Sport getSportById(Long id) {
        return sportRepository.findById(id).orElseThrow();
    }

    public List<Sport> getSportsByLocation(Long id) {
        return sportRepository.getSportsByLocation(id);
    }

    public List<Sport> getSportsByNameAndDate(List<String> names, LocalDate startingDate, LocalDate endingDate) {
        return sportRepository.getSportsByNameAndDate(names, startingDate, endingDate);
    }

    public List<Sport> getSportsByLocationName(List<Sport> sports, String place) {
        return sportRepository.getSportsByLocationName(sports, place);
    }

    public List<Sport> getSportsByCountyName(List<Sport> sports, String place) {
        return sportRepository.getSportsByCountyName(sports, place);
    }

    public List<Sport> getSportsByCountryName(List<Sport> sports, String place) {
        return sportRepository.getSportsByCountryName(sports, place);
    }
}
