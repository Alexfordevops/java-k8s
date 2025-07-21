package project.api_city.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.api_city.dto.CityCreateDTO;
import project.api_city.dto.CityDTO;
import project.api_city.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityDTO> create(@RequestBody @Validated CityCreateDTO dto) {
        CityDTO created = cityService.createCity(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> getAll() {
        return ResponseEntity.ok(cityService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
