package pl.lukaszprasek.weatherinfo.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lukaszprasek.weatherinfo.models.weather.WeatherModel;

import java.util.Scanner;

@Service
public class WeatherService {

    @Value("${openweathermap.api_key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public WeatherService() {
        restTemplate = new RestTemplate();
    }

    public WeatherModel /* todo zamienic na odpowiedni model danych */ makeCall(String city) {
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey, WeatherModel.class);

    }
}
