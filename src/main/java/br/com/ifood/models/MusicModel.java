package br.com.ifood.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.ifood.models.WeatherModel;

@Entity(name = "music")
public class MusicModel {

	private String lat;
	private String lon;

	private String category;

	@OneToOne
	private WeatherModel weatherModel;
	
	public MusicModel(String lat, String lon, String category, WeatherModel weatherModel) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.category = category;
		this.weatherModel = weatherModel;
	}

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public WeatherModel getWeatherModel() {
		return weatherModel;
	}

	public void setWeatherModel(WeatherModel weatherModel) {
		this.weatherModel = weatherModel;
	}

}
