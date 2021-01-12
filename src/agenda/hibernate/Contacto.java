package agenda.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@NamedQuery(name="consulta_por_nombre", query="FROM Contacto where nombre =: nombre")
@Entity
@Table(name="mi_tabla")
public class Contacto {
@Id
@GeneratedValue(generator="increment")
@GenericGenerator(name="increment", strategy = "increment")
private int id;

private String nombre, apellido, email;

Contacto(String nombre, String apellido, String email) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
}
Contacto() {
System.out.println("Alguien llama al constructor vacío...");
}
public String getNombre() {
	return nombre;
}

public String getApellido() {
	return apellido;
}

public String getEmail() {
	return email;
}

@Override
public String toString() {
	return "Contacto [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
}

}
