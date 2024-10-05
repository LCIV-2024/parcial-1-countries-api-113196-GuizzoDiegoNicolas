package ar.edu.utn.frc.tup.lciii.controllers;
import ar.edu.utn.frc.tup.lciii.model.Country;
import ar.edu.utn.frc.tup.lciii.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getCountries(){
        List<Country> response = countryService.getAllCountries ();
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/countries/{code,name}")
    public ResponseEntity<List<Country>> getCountriesByCodeName(@PathVariable String code,
                                                                @PathVariable String name)
    {
        List<Country> response = countryService.getCountryByCodeName (code,name);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/countries/{code,name}")
    public ResponseEntity<List<Country>> getCountriesByContinents(@PathVariable String contients)
    {
        List<Country> response = countryService.getCountriesByContinent (contients);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.ok(null);
        }
    }
}