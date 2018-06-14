package pl.lukaszprasek.weatherinfo.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherModel {//w modelu na stronie sa obiekty zagniezdzone, stad polem tej klasy jest obiekt
    //weathermodel odpowiada "Main" z JSONparser.fr
    //nawiasy klmrowe w JSON mowia czy to obiekt

    @JsonProperty("main")//nazwa z Jsona z serwisu API
//    "main":{
//        "temp":293.15,
//                "pressure":1012,
    private TempStats globalStats;


    @JsonProperty("clouds")
//    "clouds":{
//        "all":40
//    },
    private CloudStats cloudStats;

    private int visibility;//ta zmienna jest w glownym obiekcie
}
