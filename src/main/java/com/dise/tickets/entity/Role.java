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
@Table(name = "authorities")
public class Role implements Serializable{

	private static final long serialVersionUID = 2968664737152262746L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "authority", unique= true)
	private String authority;
	
	@OneToMany(mappedBy = "role")
    private List<UserTicket> userTicket;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setUserTicket(List<UserTicket> userTicket) {
		this.userTicket = userTicket;
	}

	public List<UserTicket> getUserTicket() {
		return userTicket;
	}


}
