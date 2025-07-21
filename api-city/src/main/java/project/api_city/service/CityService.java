package project.api_city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.api_city.dto.CityCreateDTO;
import project.api_city.dto.CityDTO;
import project.api_city.exception.ResourceNotFoundException;
import project.api_city.model.CityModel;
import project.api_city.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public CityDTO createCity(CityCreateDTO dto) {
        CityModel city = new CityModel();
        city.setName(dto.getName());
        city.setCountry(dto.getCountry());

        CityModel saved = cityRepository.save(city);
        return new CityDTO(saved.getId(), saved.getName(), saved.getCountry());
    }

    public List<CityDTO> listAll() {
        return cityRepository.findAll().stream()
                .map(city -> new CityDTO(city.getId(), city.getName(), city.getCountry()))
                .collect(Collectors.toList());
    }

    public CityDTO getById(Long id) {
        CityModel city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada com ID: " + id));

        return new CityDTO(city.getId(), city.getName(), city.getCountry());
    }

    public void deleteById(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cidade não encontrada para exclusão com ID: " + id);
        }
        cityRepository.deleteById(id);
    }
}
