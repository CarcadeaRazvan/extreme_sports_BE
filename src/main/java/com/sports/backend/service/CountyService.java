package com.sports.backend.service;

import com.sports.backend.model.County;
import com.sports.backend.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    private final CountyRepository countyRepository;

    @Autowired
    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public void addCounty(County county) {
        this.countyRepository.save(county);
    }

    public County getCountyById(Long id) {
        return countyRepository.getById(id);
    }

    public List<County> getCountyByCountry(Long id) {
        return countyRepository.getCountiesByCountry(id);
    }

    public List<County> getCounties() {
        return countyRepository.findAll();
    }

    public void updateCounty(County county) {
        countyRepository.save(county);
    }

    public void deleteCounty(Long id) {
        countyRepository.deleteById(id);
    }
}
