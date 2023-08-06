package com.rest.api.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;
    
    public List<Country> getAll(){
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
 
    
    public void save(Country country) {
        this.countryRepository.save(country);
    }
 
    
    
    public void deleteCountryById(long id) {
        this.countryRepository.deleteById(id);
    }
}