package br.com.ifood.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ifood.dto.MusicDto;
import br.com.ifood.dto.WeatherDto;
import br.com.ifood.exceptions.HandlerError;
import br.com.ifood.models.WeatherModel;
import br.com.ifood.services.MusicService;
import br.com.ifood.services.WeatherService;

@RestController
@RequestMapping("/api/v1")
public class MusicController extends HandlerError {

	@Autowired
	MusicService musicService;

	@Autowired
	WeatherService weatherService;

	@GetMapping("/music")
	@ResponseBody
	public ResponseEntity<?> all() {
		return ResponseEntity.ok(musicService.listAll());
	}

	@PostMapping("/music")
	@ResponseBody
	@Transactional
	public ResponseEntity<?> save(@RequestBody @Valid MusicDto musicDto, Errors errors)
			throws JsonParseException, JsonMappingException, IOException {

		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(getFieldsErrors(errors));
		}

		JSONObject json = weatherService.requestWeather(musicDto);

		ObjectMapper m = new ObjectMapper();

		WeatherDto weathDto = m.readValue(json.toString(), WeatherDto.class);

		WeatherModel weathModel = weatherService.save(weathDto);

		String category = weatherService.searchCategoryBaseTemp(weathModel);

		JSONObject jsonServiceSpotify = musicService.searchMusicSpotifyCategory(category);

		System.out.println(jsonServiceSpotify.toString());

		jsonServiceSpotify = jsonServiceSpotify.getJSONObject("playlists");

		JSONArray arrayJson = jsonServiceSpotify.getJSONArray("items");

		jsonServiceSpotify = new JSONObject(arrayJson.get(0).toString());

		jsonServiceSpotify = (JSONObject) jsonServiceSpotify.get("external_urls");

		MusicDto jsonMusicDto = m.readValue(jsonServiceSpotify.toString(), MusicDto.class);

		musicDto.setSpotify(jsonMusicDto.getSpotify());
		musicDto.setCategory(category);
		musicDto.setWeatherModel(weathModel);

		 return ResponseEntity.ok().body(musicService.save(musicDto));
		return ResponseEntity.ok().body(jsonServiceSpotify.toString())
	}

}
