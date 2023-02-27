package com.pxl.superhero.service.impl;

import com.pxl.superhero.api.SuperheroDTO;
import com.pxl.superhero.api.SuperheroRequest;
import com.pxl.superhero.domain.Superhero;
import com.pxl.superhero.exception.ResourceNotFoundException;
import com.pxl.superhero.repository.SuperheroRepository;
import com.pxl.superhero.service.SuperheroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroServiceImpl implements SuperheroService {

	private final SuperheroRepository superheroRepository;

	public SuperheroServiceImpl(SuperheroRepository superheroRepository) {
		this.superheroRepository = superheroRepository;
	}

	public List<SuperheroDTO> findAllSuperheroes() {
		return superheroRepository.findAll().stream().map(SuperheroDTO::new).toList();
	}

	public SuperheroDTO findSuperheroById(Long superheroId) {
		return superheroRepository.findById(superheroId).map(SuperheroDTO::new).orElseThrow(() -> new ResourceNotFoundException("Superhero", "ID", superheroId));
	}

	public Long createSuperhero(SuperheroRequest superheroRequest) {
		Superhero superhero = new Superhero();
		superhero.setFirstName(superheroRequest.getFirstName());
		superhero.setLastName(superheroRequest.getLastName());
		superhero.setSuperheroName(superheroRequest.getSuperheroName());
		Superhero newSuperhero = superheroRepository.save(superhero);
		return newSuperhero.getId();
	}

	public SuperheroDTO updateSuperhero(Long superheroId, SuperheroRequest superheroRequest) {
		return superheroRepository.findById(superheroId).map(superhero -> {
				superhero.setFirstName(superheroRequest.getFirstName());
				superhero.setLastName(superheroRequest.getLastName());
				superhero.setSuperheroName(superheroRequest.getSuperheroName());
				return new SuperheroDTO(superheroRepository.save(superhero));
		}).orElseThrow(() -> new ResourceNotFoundException("Superhero", "id", superheroId));
	}

	public boolean deleteSuperhero(Long superheroId) {
    return superheroRepository.findById(superheroId).map(superhero -> {
			superheroRepository.delete(superhero);
			return true;
		}).orElseThrow(() -> new ResourceNotFoundException("Superhero", "id", superheroId));
	}
}
