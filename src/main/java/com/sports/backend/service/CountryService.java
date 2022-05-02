package com.sports.backend.service;

import com.sports.backend.model.Country;
import com.sports.backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    public void updateCountry(Country country) {
        countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
