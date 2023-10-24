package tpe3.arquitectura.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudiante_spring2")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dni;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private int edad;

	@Column(nullable = false)
	private String genero;

	@Column(nullable = false)
	private String ciudad;

	@Column(name = "LU", nullable = false)
	private int nroLibretaUnica;

	public Estudiante() {
		super();
	}

	public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad,
			int nroLibretaUnica) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.nroLibretaUnica = nroLibretaUnica;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getNroLibretaUnica() {
		return nroLibretaUnica;
	}

	public void setNroLibretaUnica(int nroLibretaUnica) {
		this.nroLibretaUnica = nroLibretaUnica;
	}
}
