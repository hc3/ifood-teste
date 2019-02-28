package br.com.ifood.dto;

public class WeatherDto {

	private Long id;

	private Integer temp;

	private Integer temp_min;

	private Integer humidity;

	private Integer pressure;

	private Integer temp_max;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(int temp_min) {
		this.temp_min = temp_min;
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

	public int getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(int temp_max) {
		this.temp_max = temp_max;
	}

	
	
}
