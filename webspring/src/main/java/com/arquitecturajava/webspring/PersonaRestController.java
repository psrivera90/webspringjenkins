package com.arquitecturajava.webspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitecturajava.webspring.dtos.PersonaDto;
import com.arquitecturajava.webspring.mappers.PersonaMapper;
import com.arquitecturajava.webspring.models.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaRestController {
	
	@Autowired
	private PersonaService servicio;

	public void add(PersonaDto personaDto) {
		servicio.add(PersonaMapper.toBo(personaDto));
	}

	@GetMapping
	public List<PersonaDto> buscarTodos() {
		return servicio.buscarTodos().stream().map((p) ->new PersonaDto(p.getNombre().toUpperCase())).toList();
	}

}
