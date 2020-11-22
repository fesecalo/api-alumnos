package fesecalo.github.com.apialumnos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fesecalo.github.com.apialumnos.model.Alumno;
import fesecalo.github.com.apialumnos.repository.AlumnoRepository;
import fesecalo.github.com.apialumnos.utils.LogUtility;

import java.util.List;

@Service
public class AlumnoServiceImp implements AlumnoService
{
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private LogUtility logUtility;
	
	@Override
	public void save(Alumno alumno)
	{
		logUtility.showLog("guardando alumno");
		alumnoRepository.save(alumno);
	}
	
	@Override
	public Alumno findByRut(String rut)
	{
		return alumnoRepository.findByRut(rut);
	}
	
	@Override
	public List<Alumno> findAll()
	{
		return alumnoRepository.findAll();
	}
}
