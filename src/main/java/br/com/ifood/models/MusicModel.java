package br.com.ifood.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "music")
public class MusicModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String lat;
	
	@Column(nullable = false)
	private String lon;

	@Column(nullable = false)
	private String category;	
	
	@Column(nullable = false)
	private String spotify;
	
	@OneToOne
	private WeatherModel weatherModel;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpotify() {
		return spotify;
	}

	public void setSpotify(String spotify) {
		this.spotify = spotify;
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
