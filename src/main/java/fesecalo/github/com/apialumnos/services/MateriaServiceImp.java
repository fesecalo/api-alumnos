package fesecalo.github.com.apialumnos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fesecalo.github.com.apialumnos.model.Materia;
import fesecalo.github.com.apialumnos.repository.MateriaRepository;
import fesecalo.github.com.apialumnos.utils.LogUtility;


@Service
public class MateriaServiceImp implements MateriaService
{
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private LogUtility logUtility;
	
	@Override
	public void save(Materia materia)
	{
		logUtility.showLog("guardando materia");
		materiaRepository.save(materia);
	}
}
