package com.sports.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "counties")
@SequenceGenerator(name = "countyGen", sequenceName = "countySeq")
public class County {
    @Id
    @GeneratedValue(generator = "countyGen")
    @Column(name = "countyid")
    private Long countyId;

    @Column(name = "name")
    private String name;

    @Column(name = "countryid")
    private Long countryId;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    public Long getCountyId() {
        return countyId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
