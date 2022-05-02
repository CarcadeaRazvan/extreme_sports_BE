package com.sports.backend.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sports")
@SequenceGenerator(name = "sportGen", sequenceName = "sportSeq")
public class Sport {
    @Id
    @Column(name = "sportid")
    @GeneratedValue(generator = "sportGen")
    private Long sportId;

    @Column(name = "name")
    private String name;

    @Column(name = "avgcostperday")
    private Double avgCostPerDay;

    @Column(name = "startingdate", columnDefinition = "date")
    private LocalDate startingDate;

    @Column(name = "endingdate", columnDefinition = "date")
    private LocalDate endingDate;

    @Column(name = "locationid")
    private Long locationId;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    public Long getSportId() {
        return sportId;
    }

    public String getName() {
        return name;
    }

    public Double getAvgCostPerDay() {
        return avgCostPerDay;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public Location getLocation() {
        return location;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void updateAvgCostPerDay(Double avgCostPerDay) {
        this.avgCostPerDay = avgCostPerDay;
    }

    public void updateStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void updateEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
