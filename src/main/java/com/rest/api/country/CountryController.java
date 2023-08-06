package com.rest.api.country;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    public List<Country> getAll() {
        return countryService.getAll();
    }

    
        @GetMapping("/{id}")
    public Country getCourseById(@PathVariable( value = "id")long id) {
        return countryService.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> saveCountry(@RequestBody Country country) {
        countryService.save(country);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("created sucessfully");

    }
}