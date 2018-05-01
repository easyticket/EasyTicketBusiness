package com.dise.tickets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
}
