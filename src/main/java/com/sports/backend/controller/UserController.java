package com.sports.backend.controller;

import com.sports.backend.model.Holiday;
import com.sports.backend.model.Results;
import com.sports.backend.model.Sport;
import com.sports.backend.service.CountryService;
import com.sports.backend.service.CountyService;
import com.sports.backend.service.LocationService;
import com.sports.backend.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private Holiday holiday;

    private final SportService sportService;
    private final LocationService locationService;
    private final CountyService countyService;
    private final CountryService countryService;

    @Autowired
    public UserController(SportService sportService, LocationService locationService,
                           CountyService countyService, CountryService countryService) {
        this.sportService = sportService;
        this.locationService = locationService;
        this.countyService = countyService;
        this.countryService = countryService;
    }

    @PostMapping("/getHoliday")
    public Results getHoliday(@NonNull @RequestBody Holiday holiday) {
        this.holiday = holiday;
        Results results = new Results();
        List<Sport> sports = sportService.getSportsByNameAndDate(holiday.getNames(), holiday.getStartingDate(), holiday.getEndingDate());

        if (holiday.getLocation() != null) {
            sports = sportService.getSportsByLocationName(sports, holiday.getLocation());
            results.setAreaName(holiday.getLocation());
        } else if (holiday.getCounty() != null) {
            sports = sportService.getSportsByCountyName(sports, holiday.getCounty());
            results.setAreaName(holiday.getCounty());
        } else if (holiday.getCountry() != null) {
            sports = sportService.getSportsByCountryName(sports, holiday.getCountry());
            results.setAreaName(holiday.getCountry());
        }

        results.setFindings(results.getFindingsByHoliday(sports, holiday));
        return results;
    }
}
