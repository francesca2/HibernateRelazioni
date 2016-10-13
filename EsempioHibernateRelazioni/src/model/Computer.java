package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Computer {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_computer;
	private String modello;
	
	//Relazione many to one senza creazione di tabella intermedia ma solo con colonna aggiuntiva con foreign key
//	@ManyToOne
//	private Persona persona;
	//relazione many to many
	@ManyToMany
	private Set<Persona> persone= new HashSet<Persona>();
	
	public Computer() {
		this.modello = " ";
	}

	public Computer(long id_computer, String modello) {
		this.id_computer = id_computer;
		this.modello = modello;
	}

	public long getId_computer() {
		return id_computer;
	}

	public void setId_computer(long id_computer) {
		this.id_computer = id_computer;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Set<Persona> getPersone() {
		return persone;
	}

	public void setPersone(Set<Persona> persone) {
		this.persone = persone;
	}

//	public Persona getPersona() {
//		return persona;
//	}
//
//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}
	
	public void addPersona(Persona p){
		this.persone.add(p);
	}

}
