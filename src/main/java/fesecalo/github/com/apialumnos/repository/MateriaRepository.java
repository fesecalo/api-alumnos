package fesecalo.github.com.apialumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fesecalo.github.com.apialumnos.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>
{
	
}