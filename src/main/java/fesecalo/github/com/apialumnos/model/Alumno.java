package fesecalo.github.com.apialumnos.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@Entity
public class Alumno
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rut;
	private String nombre;
	private String direccion;
	
	@JsonManagedReference
	@OneToMany
	private Set<Materia> materiaList;
}