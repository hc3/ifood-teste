package br.com.ifood.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifood.dto.MusicDto;
import br.com.ifood.dto.WeatherDto;
import br.com.ifood.models.WeatherModel;
import br.com.ifood.repositories.WeatherRepository;

@Service
public class WeatherService extends AbstractService {

	static String url = "https://openweathermap.org/data/2.5/weather/?appid=b6907d289e10d714a6e88b30761fae22";
	static String method = "GET";

	@Autowired
	private WeatherRepository weatherRepository;
	
	private String category = "classica";

	@Autowired
	private RequestService requestService;

	public JSONObject requestWeather(MusicDto musicDto) {
		JSONObject objectReturn = new JSONObject();
		System.out.println(musicDto.getLat());
		System.out.println(musicDto.getLon());
		System.out.println(url + "&lat=" + musicDto.getLat() + "&lon=" + musicDto.getLon());
		try {
			objectReturn = requestService.request(url + "&lat=" + musicDto.getLat() + "&lon=" + musicDto.getLon(),
					method, null);
			objectReturn = (JSONObject) objectReturn.get("main");

		} catch (MalformedURLException urlException) {
			urlException.printStackTrace();

		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return objectReturn;
	}

	public List<WeatherModel> listAll() {
		List<WeatherModel> list = (List<WeatherModel>) weatherRepository.findAll();
		return list;
	}

	public WeatherDto listOne(Long id) {
		return convertSimple(weatherRepository.findById(id), WeatherDto.class);
	}

	public WeatherModel save(WeatherDto weather) {
		return weatherRepository.save(convertSimple(weather, WeatherModel.class));
	}

	public String searchCategoryBaseTemp(WeatherModel weatherModel) {
		if (weatherModel.getTemp() > 30) category = "festa";
		if (weatherModel.getTemp() >= 15 && weatherModel.getTemp() <= 30) category = "pop";
		if (weatherModel.getTemp() >= 10 && weatherModel.getTemp() <= 14) category = "rock";
		return category;
	}
}
