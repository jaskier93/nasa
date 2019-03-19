package cosmic.controllers;

import cosmic.models.Planet;
import cosmic.models.dtos.PlanetDto;
import cosmic.services.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    /*
    DAO
    * */
    @GetMapping("/planets")
    public List<Planet> getPlanets() {
        return planetService.getPlanets();
    }

  /*  @GetMapping("/dto/planets")
    public List<PlanetDto> getPlanetsDto() {
        return planetService.getPlanetsDto();
    }*/

 /*   @GetMapping("/dto/planets/{distance}")
    public List<PlanetDto> getPlanetByDistance(@PathVariable Long distance) {
        return planetService.getPlanetsByDistanceFromSun(distance);
    }*/

    @GetMapping("/dto/planets/{distance}")
    public List<PlanetDto> getPlanetByDistance(@RequestParam(required = false) Long distance) {
        if (distance != null && distance > 0) {
            return planetService.getPlanetsByDistanceFromSun(distance);
        } else {
            return planetService.getPlanetsDto();
        }
    }

    @PostMapping("/dto/planets")
    public Planet addPlanet(@RequestBody PlanetDto planetDto) {
        return planetService.addPlanet(planetDto);
    }

    @PutMapping("/dto/planets") //put aktualizuje
    public void updatePlanet(@RequestBody PlanetDto planetDto) {
        planetService.updatePlanet(planetDto);
    }

    @DeleteMapping("/dto/planets/{planetName}")
    public void deletePlanet(@PathVariable String planetName) {
        planetService.deletePlanet(planetName);
    }

}