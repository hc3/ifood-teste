package br.com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ifood.models.WeatherModel;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherModel, Long> {

}
