package pl.lukaszprasek.weatherinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lukaszprasek.weatherinfo.models.WeatherService;

@Controller
public class MainController {

    private WeatherService weatherService;

    @Autowired
    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    //    @GetMapping("/")
//    @ResponseBody
//    public float index() {
//        return weatherService.makeCall("Warszawa").getGlobalStats().getTemperature();
//    }
    @GetMapping("/")
    public String index() {
        return "weather";
    }
    @PostMapping("/")
    public String index (@RequestParam("city") String cityName,
                         Model model) {
        //model.addAttribute("weatherInfo", weatherService.makeCall(cityName).toString());
        model.addAttribute("temp", weatherService.makeCall(cityName).getGlobalStats().getTemperature()-273);
        return "weather";
    }

}
