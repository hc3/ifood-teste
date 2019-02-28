package br.com.ifood.dto;

import javax.validation.constraints.NotBlank;

public class MusicDto {

	
	private Long id;
	
	@NotBlank
	private String lat;
	@NotBlank
	private String lon;


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

}
