package fesecalo.github.com.apialumnos.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@Entity
public class Materia
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="alumno_id")
	private Alumno alumno;
}