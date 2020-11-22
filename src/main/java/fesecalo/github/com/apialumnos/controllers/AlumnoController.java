package fesecalo.github.com.apialumnos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import fesecalo.github.com.apialumnos.model.Alumno;
import fesecalo.github.com.apialumnos.services.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController
{
	@Autowired
	private AlumnoService alumnoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Alumno alumno)
	{
		alumnoService.save(alumno);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Alumno> findAll()
	{
		return alumnoService.findAll();
	}
	
	@GetMapping("/{rut}")
	@ResponseStatus(HttpStatus.OK)
	public Alumno findOne(@PathVariable String rut)
	{
		return alumnoService.findByRut(rut);
	}
}