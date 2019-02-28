package br.com.ifood.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifood.dto.MusicDto;
import br.com.ifood.exceptions.HandlerError;
import br.com.ifood.services.MusicService;

@RestController
@RequestMapping("/api/v1/weather")
public class MusicController extends HandlerError {

	@Autowired
	MusicService musicService;

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> all() {
		return ResponseEntity.ok(musicService.listAll());
	}
	
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody @Valid MusicDto user, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(getFieldsErrors(errors));
		}
		return null;
	}

}
