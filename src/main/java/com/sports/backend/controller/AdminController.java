package com.sports.backend.controller;

import com.sports.backend.model.Country;
import com.sports.backend.model.County;
import com.sports.backend.model.Location;
import com.sports.backend.model.Sport;
import com.sports.backend.service.CountryService;
import com.sports.backend.service.CountyService;
import com.sports.backend.service.LocationService;
import com.sports.backend.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin")
@RestController
public class AdminController {
    private final SportService sportService;
    private final LocationService locationService;
    private final CountyService countyService;
    private final CountryService countryService;

    @Autowired
    public AdminController(SportService sportService, LocationService locationService,
                           CountyService countyService, CountryService countryService) {
        this.sportService = sportService;
        this.locationService = locationService;
        this.countyService = countyService;
        this.countryService = countryService;
    }

    @PostMapping("/sport/addSport")
    public void addSport(@NonNull @RequestBody Sport sport) {
        Location location = locationService.getLocationById(sport.getLocationId());
        sport.setLocation(location);
        sportService.addSport(sport);
    }

    @PostMapping("/sport/updateSport")
    public void updateSport(@NonNull @RequestBody Sport sport) {
        Location location = locationService.getLocationById(sport.getLocationId());
        sport.setLocation(location);
        sportService.deteleSport(sport.getSportId());
        sportService.updateSport(sport);
    }

    @DeleteMapping(path = "/sport/deleteSport/{id}")
    public void deleteSport(@NonNull @PathVariable Long id) {
        sportService.deteleSport(id);
    }

    @GetMapping("/sport/getSports")
    public List<Sport> getSports() {
        return sportService.getSports();
    }

    @PostMapping("/location/addLocation")
    public void addLocation(@NonNull @RequestBody Location location) {
        County county = countyService.getCountyById(location.getCountyId());
        location.setCounty(county);
        locationService.addLocation(location);
    }

    @PostMapping("/location/updateLocation")
    public void updateLocation(@NonNull @RequestBody Location location) {
        County county = countyService.getCountyById(location.getCountyId());
        location.setCounty(county);
        locationService.deleteLocation(location.getLocationId());
        locationService.updateLocation(location);
    }

    @GetMapping("/location/getLocations")
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @DeleteMapping(path = "/location/deleteLocation/{id}")
    public void deleteLocation(@NonNull @PathVariable Long id) {
        List<Sport> sports = sportService.getSportsByLocation(id);
        for (Sport sport : sports) {
            sportService.deteleSport(sport.getSportId());
        }
        locationService.deleteLocation(id);
    }

    @PostMapping("/county/addCounty")
    public void addCounty(@NonNull @RequestBody County county) {
        Country country = countryService.getCountryById(county.getCountryId());
        county.setCountry(country);
        countyService.addCounty(county);
    }

    @PostMapping("/county/updateCounty")
    public void updateCounty(@NonNull @RequestBody County county) {
        Country country = countryService.getCountryById(county.getCountryId());
        county.setCountry(country);
        countyService.deleteCounty(county.getCountyId());
        countyService.updateCounty(county);
    }

    @GetMapping("/county/getCounties")
    public List<County> getCounties() {
        return countyService.getCounties();
    }

    @DeleteMapping(path = "/county/deleteCounty/{id}")
    public void deleteCounty(@NonNull @PathVariable Long id) {
        List<Location> locations = locationService.getLocationsByCounty(id);
        for (Location location : locations) {
            List<Sport> sports = sportService.getSportsByLocation(location.getLocationId());
            for (Sport sport : sports) {
                sportService.deteleSport(sport.getSportId());
            }
            locationService.deleteLocation(location.getLocationId());
        }
        countyService.deleteCounty(id);
    }

    @PostMapping("/country/addCountry")
    public void addCountry(@NonNull @RequestBody Country country) {
        countryService.addCountry(country);
    }

    @PostMapping("/country/updateCountry")
    public void updateCountry(@NonNull @RequestBody Country country) {
        countryService.deleteCountry(country.getCountryId());
        countryService.updateCountry(country);
    }

    @GetMapping("/country/getCountries")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @DeleteMapping(path = "/country/deleteCountry/{id}")
    public void deleteCountry(@NonNull @PathVariable Long id) {
        List<County> counties = countyService.getCountyByCountry(id);
        for (County county : counties) {
            List<Location> locations = locationService.getLocationsByCounty(county.getCountyId());
            for (Location location : locations) {
                List<Sport> sports = sportService.getSportsByLocation(location.getLocationId());
                for (Sport sport : sports) {
                    sportService.deteleSport(sport.getSportId());
                }
                locationService.deleteLocation(location.getLocationId());
            }
            countyService.deleteCounty(county.getCountyId());
        }
        countryService.deleteCountry(id);
    }
}
