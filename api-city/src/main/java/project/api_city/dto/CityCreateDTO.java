package project.api_city.dto;

import jakarta.validation.constraints.NotBlank;

public class CityCreateDTO {

    @NotBlank(message = "O nome da cidade é obrigatório")
    private String name;

    @NotBlank(message = "O país é obrigatório")
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
