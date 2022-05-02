package com.sports.backend.model;

import java.time.LocalDate;
import java.util.List;

public class Holiday {
    private List<String> names;

    private LocalDate startingDate;

    private LocalDate endingDate;

    private String location;

    private String county;

    private String country;

    public List<String> getNames() {
        return names;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public String getLocation() {
        return location;
    }

    public String getCounty() {
        return county;
    }

    public String getCountry() {
        return country;
    }
}
