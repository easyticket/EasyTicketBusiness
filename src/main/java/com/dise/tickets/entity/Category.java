package com.dise.tickets.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category  implements Serializable{

	private static final long serialVersionUID = 158628107750062679L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="name")
	private String name;
	
	@Column (name="description")
	private String description;

	@OneToMany(mappedBy = "category")
    private List<SocialEvent> socialEvents;
}
