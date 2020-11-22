package fesecalo.github.com.apialumnos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import fesecalo.github.com.apialumnos.model.Materia;
import fesecalo.github.com.apialumnos.services.MateriaService;

@RestController
@RequestMapping("/api/v1/materias")
public class MateriaController
{
	@Autowired
	private MateriaService materiaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Materia materia)
	{
		materiaService.save(materia);
	}
}