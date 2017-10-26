package com.blissWebApp.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Machine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_machine")
	private int idMachine;
	@Column(name="id_salle")
	private int idSalle;
	@Column(name="nom_machine")
	private String nomMachine;
	@Column(name="url_machine")
	private String urlMachine;
	@Column(name="ram")
	private String ram;
	@Column(name="etat")
	private boolean etat;
	@Column(name="message")
	private String message;
	@Column(name="date_dernier_recut")
	private String dateDernierRecut;
	@Column(name="disque")
	private String disque;
	
	public int getIdMachine() {
		return idMachine;
	}
	public void setIdMachine(int idMachine) {
		this.idMachine = idMachine;
	}
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public String getNomMachine() {
		return nomMachine;
	}
	public void setNomMachine(String nomMachine) {
		this.nomMachine = nomMachine;
	}
	public String getUrlMachine() {
		return urlMachine;
	}
	public void setUrlMachine(String urlMachine) {
		this.urlMachine = urlMachine;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateDernierRecut() {
		return dateDernierRecut;
	}
	public void setDateDernierRecut(String dateDernierRecut) {
		this.dateDernierRecut = dateDernierRecut;
	}
	public String getDisque() {
		return disque;
	}
	public void setDisque(String disque) {
		this.disque = disque;
	}
}
