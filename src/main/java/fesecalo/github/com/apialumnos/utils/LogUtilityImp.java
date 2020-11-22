package fesecalo.github.com.apialumnos.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component//Indica que una clase anotada es un "componente". Dichas clases se consideran candidatas para la detección automática cuando se utiliza una configuración basada en anotaciones y un escaneo de rutas de clases.
public class LogUtilityImp implements LogUtility {
	
	private static final Logger log = LoggerFactory.getLogger(LogUtilityImp.class);
	@Override
	public void showLog(String msg) {
		log.info(msg);
	}

}
