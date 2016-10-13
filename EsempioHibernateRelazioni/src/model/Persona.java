package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Persona {

		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id_persona;

		private String nome;
		private String cognome;
		
		//relazione one to one
//		@OneToOne
//		private Computer computer;
		//relazione many to one
//		@OneToMany(mappedBy="persona")
		//relazione many to many, il mapped mi serve per non creare due tabelle join
		@ManyToMany(mappedBy="persone")
		private Set<Computer> computer=new HashSet<Computer>();
		

		
		public Persona() {
			this.nome = " ";
			this.cognome = " ";
		}

		public Persona(int id_persona, String nome, String cognome) {
			this.id_persona = id_persona;
			this.nome = nome;
			this.cognome = cognome;
		}

		public int getId_persona() {
			return id_persona;
		}

		public void setId_persona(int id_persona) {
			this.id_persona = id_persona;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public Set<Computer> getComputer() {
			return computer;
		}

		public void setComputer(Set<Computer> computer) {
			this.computer = computer;
		}

//		public Computer getComputer() {
//			return computer;
//		}
//
//		public void setComputer(Computer computer) {
//			this.computer = computer;
//		}

		public void addComputer(Computer c){
			this.computer.add(c);
		}
		
	}