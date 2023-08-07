package com.rest.api.city;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City getById(long id) {
        Optional<City> optionalCountry = cityRepository.findById(id);
        if (optionalCountry.isPresent()) {
            return optionalCountry.get();
        } else {
            throw new RuntimeException("City not found for id : " + id);
        }
    }

    public void save(City city) {
        this.cityRepository.save(city);
    }

    public void updateById(Long id, City city) {
        Optional<City> optionalCountry = this.cityRepository.findById(id);
        if (optionalCountry.isPresent()) {
            City countryDb = optionalCountry.get();
            if (city.getCity() != null) {
                countryDb.setCity(city.getCity());
            }

            this.cityRepository.save(countryDb);

        } else {
            throw new RuntimeException("City not found for id : " + id);
        }
    }

    public void deleteCountryById(long id) {
        this.cityRepository.deleteById(id);
    }
}
