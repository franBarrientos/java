package com.rest.api.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping
    public List<City> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public City getCountryById(@PathVariable(value = "id") long id) {
        return cityService.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> saveCountry(@RequestBody City city) {
        cityService.save(city);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("created sucessfully");

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCountry(@PathVariable(value = "id") long id, @RequestBody City city) {
        cityService.updateById(id, city);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("updated");
    }
}
