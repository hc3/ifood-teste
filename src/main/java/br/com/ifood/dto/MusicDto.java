package br.com.ifood.dto;

import javax.validation.constraints.NotBlank;

import br.com.ifood.models.WeatherModel;

public class MusicDto {

	
	private Long id;
	@NotBlank
	private String lat;
	@NotBlank
	private String lon;

	private String category;
	
	private String spotify;
	
	private WeatherModel weatherModel;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSpotify() {
		return spotify;
	}

	public void setSpotify(String spotify) {
		this.spotify = spotify;
	}

	public WeatherModel getWeatherModel() {
		return weatherModel;
	}

	public void setWeatherModel(WeatherModel weatherModel) {
		this.weatherModel = weatherModel;
	}

}
