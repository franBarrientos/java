package com.rest.api.country;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rest.api.city.City;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "people")
    private Long people;

    @OneToMany(targetEntity = City.class, mappedBy = "country")
    @JsonManagedReference
    private List<City> cities;

    public List<City> getCities() {
        return this.cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Country(Long id, String country, String region, Long people) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.people = people;
    }

    public Country() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getPeople() {
        return this.people;
    }

    public void setPeople(Long people) {
        this.people = people;
    }
}
