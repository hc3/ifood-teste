package br.com.ifood.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifood.dto.MusicDto;
import br.com.ifood.models.MusicModel;
import br.com.ifood.repositories.MusicRepository;

@Service
public class MusicService extends AbstractService {

	private static String url = "https://api.spotify.com/v1/browse/categories/";
	private static String token = "BQBeTTzKqmi5thkO2RP79fv5U2mhQTYa7VYj93M1xtUTNk25L_pexv4nWg_PYCMLZuONzTw975jwYAJjavYXPbjfzmB2XwXhbCAIdSl8D1kwccNFL-tm9rkiFxw1dRFJbBegS5r5V2w0oNU";

	@Autowired
	private MusicRepository musicRepository;

	@Autowired
	private RequestService requestService;

	public List<MusicDto> listAll() {
		List<MusicModel> list = (List<MusicModel>) musicRepository.findAll();
		return convertList(list, MusicDto.class);
	}

	public MusicDto listOne(Long id) {
		return convertSimple(musicRepository.findById(id), MusicDto.class);
	}

	public MusicModel save(MusicDto user) {
		return musicRepository.save(convertSimple(user, MusicModel.class));
	}

	public JSONObject searchMusicSpotifyCategory(String category) {
		JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse = requestService.request(MusicService.url + category  + "/playlists?country=BR&limit=10&offset=5" , "GET", MusicService.token);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResponse;
	}

}
