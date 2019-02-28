package br.com.ifood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifood.dto.MusicDto;
import br.com.ifood.models.MusicModel;
import br.com.repositories.MusicRepository;


@Service
public class MusicService extends AbstractService {

	
	@Autowired
	MusicRepository musicRepository;
	
	public List<MusicDto> listAll() {
		List<MusicModel> list = (List<MusicModel>) musicRepository.findAll();
		return convertList(list, MusicDto.class); 
	}
	
	public MusicDto listOne(Long id) {
		return convertSimple(musicRepository.findById(id), MusicDto.class);
	}
	
	public void save(MusicDto user) {
		musicRepository.save(convertSimple(user, MusicModel.class));
	}
}
