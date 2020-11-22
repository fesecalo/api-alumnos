package fesecalo.github.com.apialumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fesecalo.github.com.apialumnos.model.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Long>
{
	Alumno findByRut(String rut);
}