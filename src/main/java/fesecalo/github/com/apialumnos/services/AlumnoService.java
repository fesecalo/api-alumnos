package fesecalo.github.com.apialumnos.services;

import java.util.List;
import fesecalo.github.com.apialumnos.model.Alumno;

public interface AlumnoService
{
	void save(Alumno alumno);
	Alumno findByRut(String rut);
	List<Alumno> findAll();
}