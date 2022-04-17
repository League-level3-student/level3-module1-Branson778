package _08_California_Weather;

import java.util.HashMap;

public class Place_Weather {
	void start() {
    HashMap<String, WeatherData> we = Utilities.getWeatherData();
    for(String cit: we.keySet()) {
    String city = cit;
    WeatherData weather = we.get(cit);
    if(we.get(cit)==null) {
    	System.out.println("Could Not Get Weather For "+ cit);
    }
    else {
    	System.out.println(city+ " Is Currently "+ weather.weatherSummary+ " And Is "+ weather.temperatureF+ "F");
    }
    }
	}
}
