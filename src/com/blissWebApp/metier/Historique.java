package com.blissWebApp.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_historique")
	private Integer idHistorique;
	@Column(name="id_machine")
	private Integer idMachine;
	@Column(name="nom_machine")
	private String nomMachine;
	private String message;
	private String date;
	public Integer getIdHistorique() {
		return idHistorique;
	}
	public void setIdHistorique(Integer idHistorique) {
		this.idHistorique = idHistorique;
	}
	public Integer getIdMachine() {
		return idMachine;
	}
	public void setIdMachine(Integer idMachine) {
		this.idMachine = idMachine;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNomMachine() {
		return nomMachine;
	}
	public void setNomMachine(String nomMachine) {
		this.nomMachine = nomMachine;
	}
	
	
}
