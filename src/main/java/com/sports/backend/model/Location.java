package com.sports.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@SequenceGenerator(name = "locationGen", sequenceName = "locationSeq")
public class Location {
    @Id
    @GeneratedValue(generator = "locationGen")
    @Column(name = "locationId")
    private Long locationId;

    @Column(name = "name")
    private String name;

    @Column(name = "countyId")
    private Long countyId;

    @ManyToOne
    @JoinColumn(name = "county")
    private County county;

    public Long getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    public Long getCountyId() {
        return countyId;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }
}
