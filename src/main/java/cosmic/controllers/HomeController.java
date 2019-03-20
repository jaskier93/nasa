package cosmic.controllers;

import cosmic.services.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private PlanetService planetService;

    public HomeController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/planets")
    public String homePage(Model model) {
        model.addAttribute("planets", planetService.getPlanetsDto());
        return "planets";
    }

}
