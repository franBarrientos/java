package com.rest.api.country;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByCountry(String country);
}
