package com.rest.api.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAll() {
        return countryRepository.findAll();

    }

    public Country getById(long id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()) {
            return optionalCountry.get();
        } else {
            throw new RuntimeException("Course not found for id : " + id);
        }
    }

    public Country getName(String name) {
        List<Country> countries = countryRepository.findByCountry(name);
        if (!countries.isEmpty()) {
            return countries.get(0);
        } else {
            throw new RuntimeException("Course not found for id : " + name);
        }
    }

    public void save(Country country) {
        this.countryRepository.save(country);
    }

    public void updateById(Long id, Country country) {
        Optional<Country> optionalCountry = this.countryRepository.findById(id);
        if (optionalCountry.isPresent()) {
            Country countryDb = optionalCountry.get();
            if (country.getCountry() != null) {
                countryDb.setCountry(country.getCountry());
            }
            if (country.getRegion() != null) {
                countryDb.setRegion(country.getRegion());
            }
            if (country.getPeople() != null) {
                countryDb.setPeople(country.getPeople());
            }

            this.countryRepository.save(countryDb);

        } else {
            throw new RuntimeException("Course not found for id : " + id);
        }
    }

    public void deleteCountryById(long id) {
        this.countryRepository.deleteById(id);
    }
}