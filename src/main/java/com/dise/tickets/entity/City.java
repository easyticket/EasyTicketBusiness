package com.dise.tickets.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	@Id
	@Column(name = "id_city")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCity;
	
	@Column (name="name_city")
	private String nameCity;

	@OneToMany(mappedBy = "city")
    private List<Enterprise> enterprise;
	
	
	public City() {
		super();
	}

	public City(Long idCity, String nameCity) {
		super();
		this.idCity = idCity;
		this.nameCity = nameCity;
	}

	public List<Enterprise> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(List<Enterprise> enterprise) {
		this.enterprise = enterprise;
	}

	public Long getIdCity() {
		return idCity;
	}

	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}
	
	
	
}
