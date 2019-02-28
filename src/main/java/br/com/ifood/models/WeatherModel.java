package br.com.ifood.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="weather")
public class WeatherModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private int temp;
	@Column(nullable = false)
	private int tempMin;
	@Column(nullable = false)
	private int humidity;
	@Column(nullable = false)
	private int pressure;
	@Column(nullable = false)
	private int tempMax;
	
	
	public WeatherModel(int temp, int tempMin, int humidity, int pressure, int tempMax) {
		super();
		this.temp = temp;
		this.tempMin = tempMin;
		this.humidity = humidity;
		this.pressure = pressure;
		this.tempMax = tempMax;
	}


	public int getTemp() {
		return temp;
	}


	public void setTemp(int temp) {
		this.temp = temp;
	}


	public int getTempMin() {
		return tempMin;
	}


	public void setTempMin(int tempMin) {
		this.tempMin = tempMin;
	}


	public int getHumidity() {
		return humidity;
	}


	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}


	public int getPressure() {
		return pressure;
	}


	public void setPressure(int pressure) {
		this.pressure = pressure;
	}


	public int getTempMax() {
		return tempMax;
	}


	public void setTempMax(int tempMax) {
		this.tempMax = tempMax;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
}
