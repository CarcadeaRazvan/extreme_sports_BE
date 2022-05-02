package com.sports.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@SequenceGenerator(name = "countryGen", sequenceName = "countrySeq")
public class Country {
    @Id
    @GeneratedValue(generator = "countryGen")
    @Column(name = "countryId")
    private Long countryId;

    @Column(name = "name")
    private String name;

    public Long getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }
}
