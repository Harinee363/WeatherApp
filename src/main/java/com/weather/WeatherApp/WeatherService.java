package com.weather.WeatherApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	@Value("${weather.api.key}")
	private String apiKey;
	
	private final RestTemplate restTemplate;
	public WeatherService(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	private static final String BASE_URL="https://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}&units=metric";
	
	public String getWeather(String city) {
		String url=BASE_URL.replace("{city}",city).replace("{key}",apiKey);
		return restTemplate.getForObject(url,String.class);
	}

}
